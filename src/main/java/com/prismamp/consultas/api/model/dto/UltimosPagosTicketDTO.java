package com.prismamp.consultas.api.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.prismamp.consultas.api.model.base.BaseObject;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UltimosPagosTicketDTO extends BaseObject
{
	@XmlElementWrapper
	private List<TicketPagoDTO> pagos;
	@XmlElement
	private Integer indiceLote;
	
	public UltimosPagosTicketDTO()
	{
		this.pagos = new ArrayList<TicketPagoDTO>();
	}

	public List<TicketPagoDTO> getPagos()
	{
		return pagos;
	}

	public void setPagos(List<TicketPagoDTO> pagos)
	{
		this.pagos = pagos;
	}

	public Integer getIndiceLote()
	{
		return indiceLote;
	}

	public void setIndiceLote(Integer indiceLote)
	{
		this.indiceLote = indiceLote;
	}
}