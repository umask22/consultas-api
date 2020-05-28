package com.prismamp.consultas.api.util.log;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class Registro
{
	private final static String FILED_SEPARATOR = "\n";
	
	private Date inDate;
	private Date outDate;
	private String user;
	private String path;
	private String method;
	private String headers;
	private String parameters;
	private String queryParameters;
	private String request;
	private String response;
	private int status;

	public Date getInDate()
	{
		return inDate;
	}

	public void setInDate(Date inDate)
	{
		this.inDate = inDate;
	}

	public Date getOutDate()
	{
		return outDate;
	}

	public void setOutDate(Date outDate)
	{
		this.outDate = outDate;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		if (StringUtils.isEmpty(user))
			this.user = "";
		this.user = user;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public String getHeaders()
	{
		return headers;
	}

	public void setHeaders(String headers)
	{
		if (StringUtils.isEmpty(headers))
			this.headers = "";
		this.headers = headers;
	}

	public String getRequest()
	{
		return request;
	}

	public void setRequest(String request)
	{
		if (StringUtils.isEmpty(request))
			this.request = "";
		this.request = request;
	}

	public String getResponse()
	{
		return response;
	}

	public void setResponse(String response)
	{
		this.response = response;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public String getParameters()
	{
		return parameters;
	}

	public void setParameters(String parameters)
	{
		if (StringUtils.isEmpty(parameters))
			this.parameters = "";
		this.parameters = parameters;
	}

	public String getQueryParameters()
	{
		return queryParameters;
	}

	public void setQueryParameters(String queryParameters)
	{
		if (StringUtils.isEmpty(queryParameters))
			this.queryParameters = "";
		this.queryParameters = queryParameters;
	}

	@Override
	public String toString()
	{
		String separator;
		if (System.getProperties().containsKey("P2P_FIELD_SEPARATOR"))
			separator = System.getProperty("P2P_FIELD_SEPARATOR");
		else
			separator = FILED_SEPARATOR;
		
		StringBuffer sb = new StringBuffer("Registro");
		
		sb.append(separator);
		sb.append("---------------------------");
		sb.append(separator);
		
		
		sb.append("In Date: ");
		sb.append(inDate);
		sb.append(separator);
		
		sb.append("Out Date: ");
		sb.append(inDate);
		sb.append(separator);
		
		sb.append("User: ");
		sb.append(user);
		sb.append(separator);
		
		sb.append("Path: ");
		sb.append(path);
		sb.append(separator);
		
		sb.append("Method: ");
		sb.append(method);
		sb.append(separator);
		
		sb.append("Headers: ");
		sb.append(headers);
		sb.append(separator);
		
		sb.append("Parameters: ");
		sb.append(parameters);
		sb.append(separator);
		
		sb.append("Query Parameters: ");
		sb.append(queryParameters);
		sb.append(separator);
		
		sb.append("Request: ");
		sb.append(request);
		sb.append(separator);
		
		sb.append("Response: ");
		sb.append(response);
		sb.append(separator);
		
		sb.append("Status: ");
		sb.append(status);
		sb.append(separator);
		
		sb.append("Duration: ");
		sb.append((outDate.getTime() - inDate.getTime()));
		sb.append("ms");
		sb.append(separator);

		sb.append("---------------------------");

		return sb.toString();
	}
}
