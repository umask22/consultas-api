package com.prismamp.consultas.api.model.dto;

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
public class UltimosPagosDTO extends BaseObject {
	@XmlElementWrapper
	private List<PagoInfoDTO> pagos;
	@XmlElement
	private Integer indiceLote;

	public List<PagoInfoDTO> getPagos() {
		return pagos;
	}

	public void setPagos(List<PagoInfoDTO> pagos) {
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
