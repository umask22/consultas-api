package com.prismamp.consultas.api.rest.request;

public class ConsultaTransferenciasMobileRequest extends ConsultaBaseRequest {
		
	private String tokenSeguridad;

	public String getTokenSeguridad() {
		return tokenSeguridad;
	}

	public void setTokenSeguridad(String tokenSeguridad) {
		this.tokenSeguridad = tokenSeguridad;
	}
}
