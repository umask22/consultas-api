package com.prismamp.consultas.api.model.dto;

import java.util.Date;

public class TransferenciaRealizadaDTO {
	private Date fecha;

	private CuentaDTO cuentaOrigen;

	private String destinatario;

	private String bancoDestino;

	private CuentaDTO cuentaDestino;

	private double monto;

	private double impuestos;

	private char canal;

	private String nroControl;

	/**
	 * Numero de secuencia (canal=ATM).
	 */
	private String nroSecuencia;

	/**
	 * Operacion de Transferencia entre sites.
	 */
	private boolean esSinCBU = false;

	/**
	 * Operacion de Transferencia entre sites.
	 */
	private boolean esConCBU = false;

	/**
	 * Indica si se transfiere el disponible
	 */
	private boolean disponible = false;

	/**
	 * Codigo para categorizar la transferencia
	 */
	private String codConcepto = null;

	/**
	 * Referencia de la transferencia
	 */
	private String referencia = null;

	public TransferenciaRealizadaDTO() {
		cuentaOrigen = new CuentaDTO();
		cuentaDestino = new CuentaDTO();
	}

	/**
	 * @param amount
	 * @param bcoTo
	 * @param canal
	 * @param codConcepto
	 * @param ctaTo
	 * @param date
	 * @param disponible
	 * @param esConCBU
	 * @param esSinCBU
	 * @param from
	 * @param imptos
	 * @param nroControl
	 * @param nroSecuencia
	 * @param referencia
	 * @param to
	 */
	public TransferenciaRealizadaDTO(double amount, String bcoTo, char canal, String codConcepto, CuentaDTO ctaTo,
			Date date, boolean disponible, boolean esConCBU, boolean esSinCBU, CuentaDTO from, double imptos,
			String nroControl, String nroSecuencia, String referencia, String to) {
		this.monto = amount;
		this.bancoDestino = bcoTo;
		this.canal = canal;
		this.codConcepto = codConcepto;
		this.cuentaDestino = ctaTo;
		this.fecha = date;
		this.disponible = disponible;
		this.esConCBU = esConCBU;
		this.esSinCBU = esSinCBU;
		this.cuentaOrigen = from;
		this.impuestos = imptos;
		this.nroControl = nroControl;
		this.nroSecuencia = nroSecuencia;
		this.referencia = referencia;
		this.destinatario = to;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double amount) {
		this.monto = amount;
	}

	public String getBancoDestino() {
		return bancoDestino;
	}

	public void setBancoDestino(String bcoTo) {
		this.bancoDestino = bcoTo;
	}

	public char getCanal() {
		return canal;
	}

	public void setCanal(char canal) {
		this.canal = canal;
	}

	public String getCodConcepto() {
		return codConcepto;
	}

	public void setCodConcepto(String codConcepto) {
		this.codConcepto = codConcepto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public boolean isEsConCBU() {
		return esConCBU;
	}

	public void setEsConCBU(boolean esConCBU) {
		this.esConCBU = esConCBU;
	}

	public boolean isEsSinCBU() {
		return esSinCBU;
	}

	public void setEsSinCBU(boolean esSinCBU) {
		this.esSinCBU = esSinCBU;
	}

	public double getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(double imptos) {
		this.impuestos = imptos;
	}

	public String getNroControl() {
		return nroControl;
	}

	public void setNroControl(String nroControl) {
		this.nroControl = nroControl;
	}

	public String getNroSecuencia() {
		return nroSecuencia;
	}

	public void setNroSecuencia(String nroSecuencia) {
		this.nroSecuencia = nroSecuencia;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String to) {
		this.destinatario = to;
	}

	public int compareTo(Object o) {
		TransferenciaRealizadaDTO p = (TransferenciaRealizadaDTO) o;
		int ret = 0;

		if (fecha.before(p.getFecha())) {
			ret = 1;
		} else if (fecha.after(p.getFecha())) {
			ret = -1;
		}

		return ret;
	}

	public CuentaDTO getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(CuentaDTO from) {
		this.cuentaOrigen = from;
	}

	public CuentaDTO getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(CuentaDTO ctaTo) {
		this.cuentaDestino = ctaTo;
	}

}
