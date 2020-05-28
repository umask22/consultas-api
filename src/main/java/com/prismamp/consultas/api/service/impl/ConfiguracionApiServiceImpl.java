package com.prismamp.consultas.api.service.impl;

import org.jboss.resteasy.client.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.prismamp.consultas.api.exception.ConsultasApiException;
import com.prismamp.consultas.api.model.Operacion;
import com.prismamp.consultas.api.model.dto.BancoDTO;
import com.prismamp.consultas.api.rest.client.ConfiguracionApiRestClient;
import com.prismamp.consultas.api.service.ConfiguracionApiService;
import com.prismamp.consultas.api.util.rest.RestClientFactory;
import com.prismamp.consultas.api.util.rest.RestUtil;

@Service
@PropertySource("classpath:consultas-api.properties")
public class ConfiguracionApiServiceImpl implements ConfiguracionApiService {

	@Autowired
	private Environment env;

	private ConfiguracionApiRestClient configuracionClient = null;

	private ConfiguracionApiRestClient getClient() throws ConsultasApiException{
		if (configuracionClient == null) {
			initClient();
		}
		return configuracionClient;
	}

	private void initClient() {
		configuracionClient = RestClientFactory.crear(env.getProperty("configuracion.api.url"),
				env.getProperty("configuracion.api.connectiontimeout", Integer.class),
				env.getProperty("configuracion.api.receivetimeout", Integer.class), ConfiguracionApiRestClient.class);
	}

	@SuppressWarnings({ "rawtypes"})
	@Override
	public BancoDTO getBanco(String bankCode) throws ConsultasApiException {
		try {
			ClientResponse response = getClient().getBanco(bankCode);
			if (response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
				BancoDTO bancoResponse  = RestUtil.obtenerDTO(response, BancoDTO.class, bankCode, Operacion.CONSULTA_BANCO.toString());
				return bancoResponse;
			} else {
				throw new ConsultasApiException("W05","DFLT", "DFLT");
			}
		} catch (Exception e) {
			throw new ConsultasApiException("W05","DFLT", "DFLT");
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String getDocumentTypeId(String documentType) throws ConsultasApiException{
		ClientResponse response = getClient().getDocumentTypeId(documentType);
		return RestUtil.obtenerDTO(response, String.class, "DFLT", "DFLT");
	}
}
