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
public class FacturaDTO extends BaseObject
{
	@XmlElement
	private String idEmpresa;

	@XmlElement
	private String idCliente;

	@XmlElement
	private Date vencimiento;

	@XmlElement
	private Double importe;

	@XmlElement
	private int moneda;

	@XmlElement
	private String idFactura;

	@XmlElement
	private boolean otrasCuentas;

	@XmlElement
	private String descripcionPantalla;

	@XmlElement
	private String vtoPagoAutomatico;
	
    @XmlElement(required = false)
    private boolean anual = false;

	public String getIdEmpresa()
	{
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa)
	{
		this.idEmpresa = idEmpresa;
	}

	public String getIdCliente()
	{
		return idCliente;
	}

	public void setIdCliente(String idCliente)
	{
		this.idCliente = idCliente;
	}

	public Date getVencimiento()
	{
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento)
	{
		this.vencimiento = vencimiento;
	}

	public Double getImporte()
	{
		return importe;
	}

	public void setImporte(Double importe)
	{
		this.importe = importe;
	}

	public int getMoneda()
	{
		return moneda;
	}

	public void setMoneda(int moneda)
	{
		this.moneda = moneda;
	}

	public String getIdFactura()
	{
		return idFactura;
	}

	public void setIdFactura(String idFactura)
	{
		this.idFactura = idFactura;
	}

	public boolean isOtrasCuentas()
	{
		return otrasCuentas;
	}

	public void setOtrasCuentas(boolean otrasCuentas)
	{
		this.otrasCuentas = otrasCuentas;
	}

	public String getDescripcionPantalla()
	{
		return descripcionPantalla;
	}

	public void setDescripcionPantalla(String descripcionPantalla)
	{
		this.descripcionPantalla = descripcionPantalla;
	}

	public String getVtoPagoAutomatico()
	{
		return vtoPagoAutomatico;
	}

	public void setVtoPagoAutomatico(String vtoPagoAutomatico)
	{
		this.vtoPagoAutomatico = vtoPagoAutomatico;
	}

	public boolean isAnual()
	{
		return anual;
	}

	public void setAnual(boolean anual)
	{
		this.anual = anual;
	}
}
