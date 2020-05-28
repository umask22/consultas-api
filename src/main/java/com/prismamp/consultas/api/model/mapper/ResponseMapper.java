package com.prismamp.consultas.api.model.mapper;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.prismamp.consultas.api.exception.ConsultasApiException;
import com.prismamp.consultas.api.model.dto.CodigoDeBarrasDTO;
import com.prismamp.consultas.api.model.dto.Company;
import com.prismamp.consultas.api.model.dto.CompanyDTO;
import com.prismamp.consultas.api.model.dto.DeudaInfoConCBDTO;
import com.prismamp.consultas.api.model.dto.FacturaCodDeBarraDTO;
import com.prismamp.consultas.api.rest.response.CompanyResponse;
import com.prismamp.consultas.api.rest.response.ConsultaDeudaConCodigoDeBarrasResponse;
import com.prismamp.consultas.api.rest.response.DeudaCBCompaniesResponse;
import com.prismamp.consultas.api.rest.response.DeudaCBResponse;

public class ResponseMapper {
	
	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}
	
	public static DeudaCBCompaniesResponse mapOne(ConsultaDeudaConCodigoDeBarrasResponse response) throws ConsultasApiException{
		
		DeudaInfoConCBDTO deudaInfoConCBDTO =  response.getDeudaConCB();
		DeudaCBCompaniesResponse responseFinal = new DeudaCBCompaniesResponse();
		
		if(deudaInfoConCBDTO != null) {
			CodigoDeBarrasDTO codigoDeBarrasDTO =  mapper.convertValue(deudaInfoConCBDTO, CodigoDeBarrasDTO.class);
			FacturaCodDeBarraDTO facturaCodDeBarraDTO = mapper.convertValue(deudaInfoConCBDTO, FacturaCodDeBarraDTO.class);
			
			responseFinal.setBarcode_debt(codigoDeBarrasDTO);
			if(facturaCodDeBarraDTO.getCurrency().contains("32")) {
				facturaCodDeBarraDTO.setCurrency("ARS");
			}else if("840".equals(facturaCodDeBarraDTO.getCurrency())) {
				facturaCodDeBarraDTO.setCurrency("USD");
			}
			responseFinal.setInovice(facturaCodDeBarraDTO);
		}
		
		List<Company> companies = new ArrayList<Company>();
		
		for(int i = 0; i < response.getIdEmpresas().size(); i++) {
			Company company = new Company();
			company.setCompany_id(response.getIdEmpresas().get(i));
			company.setComapany_name(response.getNombreEmpresas().get(i));
			
			companies.add(company);
		}	
		responseFinal.setCompanies(companies);
		
		return responseFinal;
	}
	
	public static DeudaCBResponse mapTwo(ConsultaDeudaConCodigoDeBarrasResponse response) throws ConsultasApiException{
		
		DeudaInfoConCBDTO deudaInfoConCBDTO =  response.getDeudaConCB();
		
		CodigoDeBarrasDTO codigoDeBarrasDTO =  mapper.convertValue(deudaInfoConCBDTO, CodigoDeBarrasDTO.class);
		FacturaCodDeBarraDTO facturaCodDeBarraDTO = mapper.convertValue(deudaInfoConCBDTO, FacturaCodDeBarraDTO.class);
		
		DeudaCBResponse responseFinal = new DeudaCBResponse();
		responseFinal.setBarcode_debt(codigoDeBarrasDTO);
		if(facturaCodDeBarraDTO.getCurrency().contains("32")) {
			facturaCodDeBarraDTO.setCurrency("ARS");
		}else if("840".equals(facturaCodDeBarraDTO.getCurrency())) {
			facturaCodDeBarraDTO.setCurrency("USD");
		}
		responseFinal.setInovice(facturaCodDeBarraDTO);
		
		return responseFinal;
	}
	
	public static CompanyDTO mapCompany(CompanyResponse response)throws ConsultasApiException{
		
		CompanyDTO company = mapper.convertValue(response , CompanyDTO.class);
		company.setPaymentType(String.valueOf(response.getPayment_type()));
		company.setAllowedAmount(String.valueOf(response.getAllowed_amount()));
		
		company.setCategoryId(response.getCategory().getId());
		company.setCategoryName(response.getCategory().getName());
		company.setCategoryType(response.getCategory().getType());
		
		return company;
	}
}
