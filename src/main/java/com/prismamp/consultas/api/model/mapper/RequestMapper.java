package com.prismamp.consultas.api.model.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.prismamp.consultas.api.exception.ConsultasApiException;
import com.prismamp.consultas.api.rest.request.ClienteRequest;
import com.prismamp.consultas.api.rest.request.ConsultaDeudaConCodigoDeBarrasRequest;
import com.prismamp.consultas.api.rest.request.DeudaCBRequest;

public class RequestMapper {

	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}
	
	public static ConsultaDeudaConCodigoDeBarrasRequest map(DeudaCBRequest request) throws ConsultasApiException{
		
		ClienteRequest client = request.getClient();
		
		ConsultaDeudaConCodigoDeBarrasRequest requestFinal = mapper.convertValue(client, ConsultaDeudaConCodigoDeBarrasRequest.class);
		requestFinal.setLongCB(request.getBarcode().getBarcode_length());
		requestFinal.setNroCB(request.getBarcode().getBarcode_number());
		
		return requestFinal;
	}
}
