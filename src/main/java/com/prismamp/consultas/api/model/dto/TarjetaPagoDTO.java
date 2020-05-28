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
public class TarjetaPagoDTO extends BaseObject
{
	@XmlElement(required = true)
	private String nroTarjeta;

	@XmlElement(required = true)
	private String vencimiento;
	
	@XmlElement(required = true)
	private String codigoMedioDePago;
	
	@XmlElement(required = true)
	private String cuotas;
	
	@XmlElement(required = true)
	private Date fechaNacimiento;
	
	@XmlElement(required = true)
	private String nombre;
	
	@XmlElement(required = true)
	private String sexo;
	
	@XmlElement(required = true)
	private String tipoTarjeta;

	public String getVencimiento()
	{
		return vencimiento;
	}

	public void setVencimiento(String vencimiento)
	{
		this.vencimiento = vencimiento;
	}

	public String getCodigoMedioDePago()
	{
		return codigoMedioDePago;
	}

	public void setCodigoMedioDePago(String codigoMedioDePago)
	{
		this.codigoMedioDePago = codigoMedioDePago;
	}

	public String getNroTarjeta()
	{
		return nroTarjeta;
	}

	public void setNroTarjeta(String nroTarjeta)
	{
		this.nroTarjeta = nroTarjeta;
	}

	public String getCuotas()
	{
		return cuotas;
	}

	public void setCuotas(String cuotas)
	{
		this.cuotas = cuotas;
	}

	public Date getFechaNacimiento()
	{
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento)
	{
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getSexo()
	{
		return sexo;
	}

	public void setSexo(String sexo)
	{
		this.sexo = sexo;
	}

	public String getTipoTarjeta()
	{
		return tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta)
	{
		this.tipoTarjeta = tipoTarjeta;
	}

}