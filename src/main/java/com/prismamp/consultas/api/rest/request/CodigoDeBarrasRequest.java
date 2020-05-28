package com.prismamp.consultas.api.rest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodigoDeBarrasRequest{

	private Integer barcode_length;
	private String barcode_number;
}
