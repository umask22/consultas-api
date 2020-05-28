package com.prismamp.consultas.api.model.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.prismamp.consultas.api.model.base.BaseObject;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketPagoDTO extends BaseObject {
	@XmlElement
    private String idEmpresa;
	@XmlElement
    private Date fechaPago;
	@XmlElement
    private String transacNum;
	@XmlElement
    private String controlNum;
	@XmlElement
    private String idDeuda;
	@XmlElement
    private String descDeuda;
	@XmlElement
    private String leyPago;
	@XmlElement
    private String leyAdhesion;
	@XmlElement
    private double monto;
	@XmlElement
    private int moneda;
	@XmlElement
    private CuentaDTO cuenta;
	@XmlElement
    private TarjetaPagoDTO tarjeta;
	@XmlElement
    private boolean hostOnLine;
	@XmlElement
    private String periodoPago;
	@XmlElement
    private String idAnticipo;
	@XmlElement
    private Date vencimiento;
	@XmlElement
    private boolean prePago = false;
	@XmlElement
    private String descripcion;
    
	public CuentaDTO getCuenta() 
	{
		return cuenta;
	}

	public void setCuenta(CuentaDTO cuenta) 
	{
		this.cuenta = cuenta;
	}

	public double getMonto() 
	{
		return monto;
	}

	public void setMonto(double monto) 
	{
		this.monto = monto;
	}

	public String getControlNum() 
	{
		return controlNum;
	}

	public void setControlNum(String controlNum) 
	{
		this.controlNum = controlNum;
	}

	public String getIdEmpresa() 
	{
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) 
	{
		this.idEmpresa = idEmpresa;
	}

	public int getMoneda() 
	{
		return moneda;
	}

	public void setMoneda(int moneda) 
	{
		this.moneda = moneda;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) 
	{
		this.fechaPago = fechaPago;
	}

	public String getDescDeuda() 
	{
		return descDeuda;
	}

	public void setDescDeuda(String descDeuda) 
	{
		this.descDeuda = descDeuda;
	}

	public boolean isHostOnLine() 
	{
		return hostOnLine;
	}

	public void setHostOnLine(boolean hostOnLine) 
	{
		this.hostOnLine = hostOnLine;
	}

	public String getIdAnticipo() 
	{
		return idAnticipo;
	}

	public void setIdAnticipo(String idAnticipo) 
	{
		this.idAnticipo = idAnticipo;
	}

	public String getIdDeuda() 
	{
		return idDeuda;
	}

	public void setIdDeuda(String idDeuda) 
	{
		this.idDeuda = idDeuda;
	}

	public String getLeyAdhesion() 
	{
		return leyAdhesion;
	}

	public void setLeyAdhesion(String leyAdhesion) 
	{
		this.leyAdhesion = leyAdhesion;
	}

	public String getLeyPago() 
	{
		return leyPago;
	}

	public void setLeyPago(String leyPago) 
	{
		this.leyPago = leyPago;
	}

	public String getPeriodo() 
	{
		return periodoPago;
	}

	public void setPeriodo(String periodo) 
	{
		this.periodoPago = periodo;
	}

	public boolean isPrePago() 
	{
		return prePago;
	}

	public void setPrePago(boolean prePago) 
	{
		this.prePago = prePago;
	}

	public String getTransacNum() 
	{
		return transacNum;
	}

	public void setTransacNum(String transacNum) 
	{
		this.transacNum = transacNum;
	}

	public Date getVencimiento() 
	{
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) 
	{
		this.vencimiento = vencimiento;
	}

	public TarjetaPagoDTO getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(TarjetaPagoDTO tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getPeriodoPago() {
		return periodoPago;
	}

	public void setPeriodoPago(String periodoPago) {
		this.periodoPago = periodoPago;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
}