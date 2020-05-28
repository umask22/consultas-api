package com.prismamp.consultas.api.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.prismamp.consultas.api.model.base.BaseObject;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaDisponibleDTO extends BaseObject {
	@XmlElement
	private Double limite;
	@XmlElement
    private Double saldoCuenta;
	@XmlElement
    private Double disponiblePES;
    
	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public Double getSaldoCuenta() {
		return saldoCuenta;
	}

	public void setSaldoCuenta(Double saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}

	public Double getDisponiblePES() {
		return disponiblePES;
	}

	public void setDisponiblePES(Double disponiblePES) {
		this.disponiblePES = disponiblePES;
	}    
	
}
