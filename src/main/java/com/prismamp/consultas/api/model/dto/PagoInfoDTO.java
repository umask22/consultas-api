package com.prismamp.consultas.api.model.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prismamp.consultas.api.model.base.BaseObject;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PagoInfoDTO extends BaseObject {
	@XmlElement
	private String idEmpresa;
	@XmlElement
	private String leyenda;
	@XmlElement
	private Date fechaPago;
	@XmlElement
	private double importe;
	@XmlElement
	private String idCliente;
	@XmlElement
	private CuentaDTO cuenta;
	@XmlElement
	private String nroTransac;
	@XmlElement
	private String nroControl;
	@XmlElement
	private int moneda;
	@XmlElement
	private String descripcion;
	@XmlElement
	private String canal;
	@XmlElement
	private String fiid;
	@XmlElement
	private boolean hostOnLine;
	@XmlElement
	private String periodo;
	@XmlElement
	private String idAnticipo;
	@XmlElement
	private Date vencimiento;
	@XmlElement
	private boolean prePago;
	@XmlElement
	private boolean anulado = false;
	@XmlElement
	private String cuitEmpleador;

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public String getLeyenda() {
		return leyenda;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public double getImporte() {
		return importe;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public CuentaDTO getCuenta() {
		return cuenta;
	}

	public String getNroTransac() {
		return nroTransac;
	}

	@JsonIgnore
	public String getNroTransacTicket() {
		String aux = null;

		try {
			if (canal.equals("C")) {
				aux = nroTransac.substring(0, 4);
			} else {
				aux = nroTransac.substring(6, 10);
			}
		} catch (Exception e) {
			aux = "0000";
		}

		return aux;
	}

	public String getNroControl() {
		return nroControl;
	}

	public int getMoneda() {
		return moneda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getCanal() {
		return canal;
	}

	public String getFiid() {
		return fiid;
	}

	public boolean isHostOnLine() {
		return hostOnLine;
	}

	public String getPeriodo() {
		return periodo;
	}

	public String getIdAnticipo() {
		return idAnticipo;
	}

	public boolean isPrePago() {
		return prePago;
	}

	public String getCuitEmpleador() {
		return cuitEmpleador;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public void setCuenta(CuentaDTO cuenta) {
		this.cuenta = cuenta;
	}

	public void setNroTransac(String nroTransac) {
		this.nroTransac = nroTransac;
	}

	public void setNroControl(String nroControl) {
		this.nroControl = nroControl;
	}

	public void setMoneda(int moneda) {
		this.moneda = moneda;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public void setFiid(String fiid) {
		this.fiid = fiid;
	}

	public void setHostOnLine(boolean hostOnLine) {
		this.hostOnLine = hostOnLine;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public void setIdAnticipo(String idAnticipo) {
		this.idAnticipo = idAnticipo;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public void setPrePago(boolean prePago) {
		this.prePago = prePago;
	}

	public void setCuitEmpleador(String cuitEmpleador) {
		this.cuitEmpleador = cuitEmpleador;
	}

	public boolean isAnulado() {
		return anulado;
	}

	public void setAnulado(boolean anulado) {
		this.anulado = anulado;
	}

}
