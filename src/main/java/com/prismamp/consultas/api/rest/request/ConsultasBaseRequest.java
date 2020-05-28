package com.prismamp.consultas.api.rest.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.prismamp.consultas.api.model.base.BaseObject;
import com.prismamp.consultas.api.util.ValidacionUtil;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultasBaseRequest extends BaseObject
{
	@XmlElement(required = true)
	@JsonAlias({"fiid","bank_id"})
	@NotNull(message = "N05")
	@Pattern(regexp = ValidacionUtil.REGEX_FIID, message = "W05")
	private String fiid;

	@XmlElement(required = true)
	@JsonAlias({"tipoDocumento","document_type"})
	@NotNull(message = "N01")
	@Pattern(regexp = ValidacionUtil.REGEX_TIPO_DOCUMENTO, message = "W01")
	private String tipoDocumento;

	@XmlElement(required = true)
	@JsonAlias({"nroDocumento","document_number"})
	@NotNull(message = "N02")
	@Pattern(regexp = ValidacionUtil.REGEX_NRO_DOCUMENTO, message = "W02")
	private String nroDocumento;

	@XmlElement(required = false)
	private String password = "";

	@XmlElement(required = true)
	@JsonAlias({"canal","channel"})
	@NotNull(message = "N03")
	@Pattern(regexp = ValidacionUtil.REGEX_CANAL, message = "W03")
	private String canal;

	@XmlElement(required = true)
	@JsonAlias({"ip","ip_address"})
	@NotNull(message = "N04")
	@Pattern(regexp = ValidacionUtil.REGEX_IP, message = "W04")
	private String ip;

	@XmlElement(required = true)
	@JsonAlias({"terminal"})
	@NotNull(message = "N06")
	private String terminal;

	@XmlElement(required = false)
	@JsonAlias({"timestamp"})
	private String timestamp;
	
	@XmlElement(required = true)
	@JsonAlias({"origen","origin"})
	private String origen;

	public String getTimestamp()
	{
		return timestamp;
	}

	public void setTimestamp(String timestamp)
	{
		this.timestamp = timestamp;
	}

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

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getCanal()
	{
		return canal;
	}

	public void setCanal(String canal)
	{
		this.canal = canal;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getTerminal()
	{
		return terminal;
	}

	public void setTerminal(String terminal)
	{
		this.terminal = terminal;
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