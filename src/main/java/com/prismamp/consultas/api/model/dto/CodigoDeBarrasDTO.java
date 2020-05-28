package com.prismamp.consultas.api.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodigoDeBarrasDTO {
	
	@JsonAlias({"barcode_length","longCB"})
	@JsonProperty("barcode_length")
	private String barcodeLength;
	
	@JsonAlias({"barcode_number","nroCB"})
	@JsonProperty("barcode_number")
	private String barcodeNumber;
	
	@JsonAlias({"barcode_type","tipoCB"})
	@JsonProperty("barcode_type")
	private String barcodeType;
}
