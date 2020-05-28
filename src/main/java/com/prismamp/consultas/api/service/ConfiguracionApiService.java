package com.prismamp.consultas.api.service;

import com.prismamp.consultas.api.exception.ConsultasApiException;
import com.prismamp.consultas.api.model.dto.BancoDTO;

public interface ConfiguracionApiService {
	
	public BancoDTO getBanco(String bankCode) throws ConsultasApiException;
	
	public String getDocumentTypeId(String documentType) throws ConsultasApiException;
}