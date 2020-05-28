package com.prismamp.consultas.api.rest.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.prismamp.consultas.api.model.base.BaseObject;
import com.prismamp.consultas.api.util.ValidacionUtil;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UltimosPagosPorUsuarioRequest extends BaseObject
{
	@XmlElement(required = true)
	
	private String fiid;
	
	@XmlElement(required = true)
	@NotNull(message = "N01")
	@Pattern(regexp = ValidacionUtil.REGEX_TIPO_DOCUMENTO, message = "W01")
	private String tipoDocumento;
	
	@XmlElement(required = true)
	@NotNull(message = "N02")
	@Pattern(regexp = ValidacionUtil.REGEX_NRO_DOCUMENTO, message = "W02")
	private String nroDocumento;
	
	@XmlElement(required = true)
	private String nroPagina;

	public String getFiid()
	{
		return fiid;
	}

	public void setFiid(String fiid)
	{
		this.fiid = fiid;
	}

	public String getTipoDocumento()
	{
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento)
	{
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroDocumento()
	{
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento)
	{
		this.nroDocumento = nroDocumento;
	}

	public String getNroPagina()
	{
		return nroPagina;
	}

	public void setNroPagina(String nroPagina)
	{
		this.nroPagina = nroPagina;
	}
}
