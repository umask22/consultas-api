package com.prismamp.consultas.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovimientoDTO {
	private String fecha;
	private String detalle;
	private Double importe;
}
