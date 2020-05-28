package com.prismamp.consultas.api.rest.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonAlias;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaDeudaConCodigoDeBarrasRequest extends ConsultasBaseRequest
{
	@XmlElement(required = false)
	private String idEmpresa;
	
	@XmlElement(required = true)
	@JsonAlias({"longCB","barcode_length"})
	private Integer longCB;
	
	@XmlElement(required = true)
	@JsonAlias({"nroCB","barcode_number"})
	private String nroCB;

	public String getIdEmpresa()
	{
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa)
	{
		this.idEmpresa = idEmpresa;
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
}