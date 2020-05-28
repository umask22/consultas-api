package com.prismamp.consultas.api.service;

import com.prismamp.consultas.api.exception.ConsultasApiException;
import com.prismamp.consultas.api.rest.response.CompanyResponse;

public interface EmpresaApiService {

    public CompanyResponse getCompany (final String bankId, final String companyId) throws ConsultasApiException;
}
