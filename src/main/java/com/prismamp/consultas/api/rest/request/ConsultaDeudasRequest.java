package com.prismamp.consultas.api.rest.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaDeudasRequest extends ConsultasBaseRequest
{
	@XmlElement(required = false)
	private String msgBancoEspecial;
	@XmlElement
	private String origen;

	public String getMsgBancoEspecial()
	{
		return msgBancoEspecial;
	}

	public void setMsgBancoEspecial(String msgBancoEspecial)
	{
		this.msgBancoEspecial = msgBancoEspecial;
	}

	public String getOrigen()
	{
		return origen;
	}

	public void setOrigen(String origen)
	{
		this.origen = origen;
	}
	
}