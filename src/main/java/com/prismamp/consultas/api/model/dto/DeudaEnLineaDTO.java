package com.prismamp.consultas.api.model.dto;

public class DeudaEnLineaDTO {

	private String opcionDePago;
	
	private String descripcionCorta;
	
	private Double monto;
	
	private String descripcionOpcionDePago;

	public String getOpcionDePago() {
		return opcionDePago;
	}

	public void setOpcionDePago(String opcionDePago) {
		this.opcionDePago = opcionDePago;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getDescripcionOpcionDePago() {
		return descripcionOpcionDePago;
	}

	public void setDescripcionOpcionDePago(String descripcionOpcionDePago) {
		this.descripcionOpcionDePago = descripcionOpcionDePago;
	}
}
