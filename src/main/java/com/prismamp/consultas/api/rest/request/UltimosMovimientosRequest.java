package com.prismamp.consultas.api.rest.request;

import com.prismamp.consultas.api.model.dto.CuentaDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper=false)
public class UltimosMovimientosRequest extends ConsultaBaseRequest {
	private CuentaDTO cuenta;
	private String tokenSeguridad;
}
