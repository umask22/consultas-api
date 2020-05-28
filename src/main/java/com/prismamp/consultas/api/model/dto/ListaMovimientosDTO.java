package com.prismamp.consultas.api.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListaMovimientosDTO {
	private List<MovimientoDTO> ultimosMovimientos;
	private String fechaSaldo;
	private double saldo;
}
