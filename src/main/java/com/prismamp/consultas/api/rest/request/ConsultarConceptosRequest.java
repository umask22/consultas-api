package com.prismamp.consultas.api.rest.request;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultarConceptosRequest {
	
	@NotNull(message = "C99")
	private String aplicativo;

	public String getAplicativo() {
		return aplicativo;
	}

	public void setAplicativo(String aplicativo) {
		this.aplicativo = aplicativo;
	}
}