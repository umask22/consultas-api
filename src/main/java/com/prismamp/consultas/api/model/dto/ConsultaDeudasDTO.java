package com.prismamp.consultas.api.model.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ConsultaDeudasDTO {
	
	@XmlElementWrapper
	private List<DeudaInfoDTO> deudasPendientes;

	public List<DeudaInfoDTO> getDeudasPendientes() {
		return deudasPendientes;
	}

	public void setDeudasPendientes(List<DeudaInfoDTO> deudasPendientes) {
		this.deudasPendientes = deudasPendientes;
	}
		
}
