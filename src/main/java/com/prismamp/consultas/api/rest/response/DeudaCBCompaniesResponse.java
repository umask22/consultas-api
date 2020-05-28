package com.prismamp.consultas.api.rest.response;

import java.util.List;

import com.prismamp.consultas.api.model.dto.CodigoDeBarrasDTO;
import com.prismamp.consultas.api.model.dto.Company;
import com.prismamp.consultas.api.model.dto.CompanyDTO;
import com.prismamp.consultas.api.model.dto.FacturaCodDeBarraDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeudaCBCompaniesResponse {
	
	private List<Company> companies;
	
	private CompanyDTO company;
	
	private CodigoDeBarrasDTO barcode_debt;
	
	private FacturaCodDeBarraDTO inovice;
}
