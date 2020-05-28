package com.prismamp.consultas.api.exception;

import com.prismamp.consultas.api.model.dto.ErrorDTO;

public class ConsultasApiException extends Exception {
	private static final long serialVersionUID = -8687529854598474737L;
	private String codigo;
	private String mensaje;

	private String banco;
	private String operacion;

	public ConsultasApiException() {
		super();
	}

	public ConsultasApiException(String codigo, String banco, String operacion) {
		this();
		this.codigo = codigo;
		this.banco = banco;
		this.operacion = operacion;
	}

	public ConsultasApiException(String codigo, String mensaje) {
		this();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public ConsultasApiException(ErrorDTO errorDTO) {
		this();
		this.codigo = errorDTO.getCodigo();
		this.mensaje = errorDTO.getMensaje();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

}
