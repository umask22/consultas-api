package com.prismamp.consultas.api.rest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeudaCBRequest {
	
	private ClienteRequest client;
	private CodigoDeBarrasRequest barcode;
}
