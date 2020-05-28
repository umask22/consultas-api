package com.prismamp.consultas.api.rest.request;

import javax.xml.bind.annotation.XmlElement;

import com.prismamp.consultas.api.model.dto.CuentaDTO;

public class ConsultaDisponibleRequest extends ConsultasBaseRequest{

	@XmlElement(required = true)
	private CuentaDTO cuenta;

	public CuentaDTO getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaDTO cuenta) {
		this.cuenta = cuenta;
	}
		
}