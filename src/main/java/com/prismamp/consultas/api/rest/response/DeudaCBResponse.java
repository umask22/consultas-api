package com.prismamp.consultas.api.rest.response;

import com.prismamp.consultas.api.model.dto.CodigoDeBarrasDTO;
import com.prismamp.consultas.api.model.dto.CompanyDTO;
import com.prismamp.consultas.api.model.dto.FacturaCodDeBarraDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeudaCBResponse {
	
	private CompanyDTO company;
	
	private CodigoDeBarrasDTO barcode_debt;
	
	private FacturaCodDeBarraDTO inovice;

}
