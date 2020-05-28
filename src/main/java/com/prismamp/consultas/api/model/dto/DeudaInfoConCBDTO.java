package com.prismamp.consultas.api.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeudaInfoConCBDTO extends DeudaInfoDTO
{
	@XmlElement(required = true)
	private boolean adherida = false;
	
	@XmlElement(required = true)
	private Integer longCB;
	
	@XmlElement(required = true)
	private String nroCB;
	
	@XmlElement(required = true)
	private String tipoCB;

	public boolean isAdherida()
	{
		return adherida;
	}

	public void setAdherida(boolean adherida)
	{
		this.adherida = adherida;
	}

	public Integer getLongCB()
	{
		return longCB;
	}

	public void setLongCB(Integer longCB)
	{
		this.longCB = longCB;
	}

	public String getNroCB()
	{
		return nroCB;
	}

	public void setNroCB(String nroCB)
	{
		this.nroCB = nroCB;
	}

	public String getTipoCB()
	{
		return tipoCB;
	}

	public void setTipoCB(String tipoCB)
	{
		this.tipoCB = tipoCB;
	}
}
