package com.prismamp.consultas.api.rest.response;

import java.util.List;

import com.prismamp.consultas.api.model.dto.DeudaEnLineaDTO;

public class ConsultaDeudaEnLineaResponse {

	private String cotizacionDolar;
	
	private List<DeudaEnLineaDTO> listaDeudas;

	public String getCotizacionDolar() {
		return cotizacionDolar;
	}

	public void setCotizacionDolar(String cotizacionDolar) {
		this.cotizacionDolar = cotizacionDolar;
	}

	public List<DeudaEnLineaDTO> getListaDeudas() {
		return listaDeudas;
	}

	public void setListaDeudas(List<DeudaEnLineaDTO> listaDeudas) {
		this.listaDeudas = listaDeudas;
	}
		
	
}

