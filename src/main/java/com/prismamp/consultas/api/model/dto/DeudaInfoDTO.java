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
public class DeudaInfoDTO extends BaseObject {
    @XmlElement(required = true)
    private String idEmpresa;

    @XmlElement(required = true)
    private String idCliente;

    @XmlElement(required = true)
    private double importe;

    @XmlElement(required = true)
    private int moneda;

    @XmlElement(required = false)
    private Date vencimiento;

    @XmlElement(required = false)
    private String idFactura = null;

    @XmlElement(required = false)
    private String descPantalla;

    @XmlElement(required = false)
    private String descripcionUsuario = "";
    
    @XmlElement(required = false)
    private String pagoRecurrente;

    @XmlElement(required = false)
    private boolean anual = false;
    
	@XmlElement(required = false)
	private String modoAlta;  
    
    public String getIdEmpresa() {
	return idEmpresa;
    }

    public String getIdCliente() {
	return idCliente;
    }

    public Date getVencimiento() {
	return vencimiento;
    }

    public double getImporte() {
	return importe;
    }

    public int getMoneda() {
	return moneda;
    }

    public String getIdFactura() {
	return idFactura;
    }

    @JsonIgnore
    public boolean isPendiente() {
	return idFactura.trim().length() == 0 ? true : false;
    }

    public String getDescPantalla() {
	return descPantalla;
    }

    public void setDescPantalla(String descPantalla) {
	this.descPantalla = descPantalla;
    }

    public String getDescripcionUsuario() {
	return descripcionUsuario;
    }

    public void setDescripcionUsuario(String descripcionUsuario) {
	this.descripcionUsuario = descripcionUsuario;
    }

    public void setIdEmpresa(String idEmpresa) {
	this.idEmpresa = idEmpresa;
    }

    public void setIdCliente(String idCliente) {
	this.idCliente = idCliente;
    }

    public void setImporte(double importe) {
	this.importe = importe;
    }

    public void setMoneda(int moneda) {
	this.moneda = moneda;
    }

    public void setVencimiento(Date vencimiento) {
	this.vencimiento = vencimiento;
    }

    public void setIdFactura(String idFactura) {
	this.idFactura = idFactura;
    }

	public String getPagoRecurrente()
	{
		return pagoRecurrente;
	}

	public void setPagoRecurrente(String pagoRecurrente)
	{
		this.pagoRecurrente = pagoRecurrente;
	}

	public boolean isAnual()
	{
		return anual;
	}

	public void setAnual(boolean anual)
	{
		this.anual = anual;
	}

	public String getModoAlta() {
		return modoAlta;
	}

	public void setModoAlta(String modoAlta) {
		this.modoAlta = modoAlta;
	}
	
}