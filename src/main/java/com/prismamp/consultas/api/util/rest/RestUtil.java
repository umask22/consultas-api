package com.prismamp.consultas.api.util.rest;

import org.jboss.resteasy.client.ClientResponse;

import com.prismamp.consultas.api.exception.ConsultasApiException;
import com.prismamp.consultas.api.model.dto.ErrorDTO;

public class RestUtil {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <DtoT> DtoT obtenerDTO(ClientResponse clientResponse, Class<DtoT> claseDto, String banco, String operacion)
			throws ConsultasApiException {

		DtoT response = null;
		if (clientResponse.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			response = claseDto.cast(clientResponse.getEntity(claseDto));
		} else {
			ErrorDTO errorDTO = (ErrorDTO) clientResponse.getEntity(ErrorDTO.class);
			throw new ConsultasApiException(errorDTO.getCodigo(), banco, operacion);
		}
		return response;

	}
	

}
