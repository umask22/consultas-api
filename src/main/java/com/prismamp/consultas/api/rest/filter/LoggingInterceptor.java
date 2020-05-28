package com.prismamp.consultas.api.rest.filter;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.jboss.resteasy.spi.interception.PostProcessInterceptor;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prismamp.consultas.api.util.SecurityUtil;
import com.prismamp.consultas.api.util.log.Registro;

@Provider
@Component
@ServerInterceptor
public class LoggingInterceptor implements PreProcessInterceptor, PostProcessInterceptor
{
	Log logger = LogFactory.getLog(this.getClass());

	private final int maxJsonEntries = 20;
	private final int maxEntitySize = 10 * 1024;

	@Context
	HttpServletRequest servletRequest;

	@SuppressWarnings("static-access")
	@Override
	public ServerResponse preProcess(HttpRequest request, ResourceMethod method) throws Failure, WebApplicationException
	{
		if (!request.getUri().getPath().contains("swagger"))
		{
			Registro registro = new Registro();
			registro.setInDate(new Date());

			registro.setHeaders(request.getHttpHeaders().getRequestHeaders().values().toString());
			registro.setPath(request.getUri().getPath());
			registro.setMethod(request.getHttpMethod());
			registro.setParameters(request.getUri().getPathParameters().toString());
			registro.setQueryParameters(request.getUri().getQueryParameters().toString());
			registro.setUser(request.getUri().getPathParameters().getFirst("mailUsuario"));

			if (request.getInputStream() != null)
			{
				StringBuilder b = new StringBuilder();
				request.setInputStream(logInboundEntity(b, request.getInputStream()));
				registro.setRequest(wipeData(b.toString()));
			}

			ResteasyProviderFactory factory = ResteasyProviderFactory.getInstance();
			factory.pushContext(Registro.class, registro);
		}
		return null;
	}


	@Override
	public void postProcess(ServerResponse response)
	{
		postProcess((Response)response);
	}
	
	@SuppressWarnings({ "static-access", "rawtypes" })
	public void postProcess(Response response)
	{
		ResteasyProviderFactory factory = ResteasyProviderFactory.getInstance();
		Registro registro = factory.popContextData(Registro.class);

		if (registro != null)
		{
			registro.setOutDate(new Date());
			registro.setStatus(response.getStatus());
			if (response.getEntity() != null)
			{
				Object o = response.getEntity();
				if ((o instanceof List && ((List) o).size() <= maxJsonEntries) || !(o instanceof List))
				{
					try
					{
						ObjectMapper mapper = new ObjectMapper();
						String json;
						json = new String(mapper.writer().writeValueAsBytes(response.getEntity()));
						registro.setResponse(wipeData(json));
					}
					catch (JsonProcessingException e)
					{
					}
				}
				else
				{
					registro.setResponse("");
				}
			}
			logger.info(registro);
		}
	}

	private InputStream logInboundEntity(StringBuilder b, InputStream stream)
	{
		if (!stream.markSupported())
		{
			stream = new BufferedInputStream(stream);
		}
		stream.mark(maxEntitySize + 1);
		byte[] entity = new byte[maxEntitySize + 1];
		int entitySize;
		try
		{
			entitySize = stream.read(entity);
			if (entitySize > 0)
			{
				b.append(new String(entity, 0, Math.min(entitySize, maxEntitySize)));
				if (entitySize > maxEntitySize)
				{
					b.append("...more...");
				}
				b.append('\n');
				stream.reset();
				return stream;
			}
		}
		catch (IOException e)
		{
			return null;
		}
		return null;
	}

	private String wipeData(String json)
	{
		Object aux = null;
		try
		{
			aux = new JSONParser().parse(json);

			if (aux instanceof JSONObject)
			{
				JSONObject jsonObj = (JSONObject) aux;
				wipe(jsonObj);

				return jsonObj.toJSONString();
			}
			else if (aux instanceof JSONArray)
			{
				wipeArray((JSONArray) aux);
				return ((JSONArray) aux).toJSONString();
			}
		}
		catch (ParseException e)
		{
		}
		return json;
	}

	private void wipeArray(JSONArray jsonArray)
	{
		for (int i = 0; i < jsonArray.size(); i++)
		{
			if (jsonArray.get(i) instanceof JSONObject)
			{
				wipe((JSONObject) jsonArray.get(i));
			}
			else
			{
				if (jsonArray.get(i) instanceof JSONArray)
				{
					wipeArray((JSONArray) jsonArray.get(i));
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void wipe(JSONObject jsonObj)
	{
		for (String clave : SecurityUtil.ATRIBUTOS_OCULTOS)
		{
			if (jsonObj.containsKey(clave))
			{
				jsonObj.put(clave, "[WIPED]");
			}
		}
		for (String clave : SecurityUtil.ATRIBUTOS_ENMASCARADOS)
		{
			if (jsonObj.containsKey(clave))
			{
				jsonObj.put(clave, SecurityUtil.protect(ObjectUtils.toString(jsonObj.get(clave))));
			}
		}
		for (Object key : jsonObj.keySet())
		{
			String keyStr = (String) key;
			if (jsonObj.get(keyStr) instanceof JSONObject)
			{
				wipe((JSONObject) jsonObj.get(keyStr));
			}
			if (jsonObj.get(keyStr) instanceof JSONArray)
			{
				wipeArray((JSONArray) jsonObj.get(keyStr));
			}
		}
	}
}
