package com.prismamp.consultas.api.rest.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.prismamp.consultas.api.util.ValidacionUtil;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaFacturasRequest extends ConsultasBaseRequest
{
	@XmlElement(required = true)
	@NotNull(message = "C43")
	@Pattern(regexp = ValidacionUtil.REGEX_ID_EMPRESA, message = "C43")	
	private String idEmpresa;

	@XmlElement(required = true)
	@NotNull(message = "C44")
	@Pattern(regexp = ValidacionUtil.REGEX_ID_CLIENTE, message = "C44")	
	private String idCliente;

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

}