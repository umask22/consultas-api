package com.prismamp.consultas.api.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.prismamp.consultas.api.model.base.BaseObject;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDTO extends BaseObject
{
	@XmlElement
	private String codigo;
	
	@XmlElement
	private String mensaje;

	public ErrorDTO()
	{
		
	}
	
	public ErrorDTO(String codigo, String mensaje)
	{
		this();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}
	
	public String getCodigo()
	{
		return codigo;
	}

	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

	public String getMensaje()
	{
		return mensaje;
	}

	public void setMensaje(String mensaje)
	{
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "ErrorDTO{" +
				"codigo='" + codigo + '\'' +
				", mensaje='" + mensaje + '\'' +
				'}';
	}
}
