package com.prismamp.consultas.api.service.impl;

import org.jboss.resteasy.client.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.prismamp.consultas.api.exception.ConsultasApiException;
import com.prismamp.consultas.api.model.Operacion;
import com.prismamp.consultas.api.rest.client.EmpresasApiRestClient;
import com.prismamp.consultas.api.rest.response.CompanyResponse;
import com.prismamp.consultas.api.service.EmpresaApiService;
import com.prismamp.consultas.api.util.rest.RestClientFactory;
import com.prismamp.consultas.api.util.rest.RestUtil;


@Service
@PropertySource("classpath:consultas-api.properties")
public class EmpresasApiServiceImpl implements EmpresaApiService{
	
	private EmpresasApiRestClient client = null;

	@Autowired
	private Environment env;

	private EmpresasApiRestClient getClient() throws ConsultasApiException {
		if (client == null) {
			initClient();
		}
		return client;
	}

	private void initClient() {

		client = RestClientFactory.crear(env.getProperty("empresas.api.url"),
				env.getProperty("empresas.api.connectiontimeout", Integer.class),
				env.getProperty("empresas.api.receivetimeout", Integer.class), EmpresasApiRestClient.class);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public CompanyResponse getCompany(String bankId, String companyId) throws ConsultasApiException {

		ClientResponse response = getClient().getCompany(bankId, companyId);
		CompanyResponse companyResponse = RestUtil.obtenerDTO(response, CompanyResponse.class, bankId, Operacion.CONSULTA_COMPANIA.toString());

		return companyResponse;
	}

}
