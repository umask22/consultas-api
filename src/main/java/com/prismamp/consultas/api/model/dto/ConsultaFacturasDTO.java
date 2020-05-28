package com.prismamp.consultas.api.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.prismamp.consultas.api.model.base.BaseObject;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaFacturasDTO extends BaseObject
{
	@XmlElementWrapper
	private List<FacturaDTO> facturas = new ArrayList<FacturaDTO>();

	public List<FacturaDTO> getFacturas()
	{
		return facturas;
	}

	public void setFacturas(List<FacturaDTO> facturas)
	{
		this.facturas = facturas;
	}

}