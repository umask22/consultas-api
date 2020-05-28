package com.prismamp.consultas.api.rest.request;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultarConceptoRequest {
	
	@NotNull(message = "C99")
	private String aplicativo;

	private String nombreCorto;

	public String getAplicativo() {
		return aplicativo;
	}

	public void setAplicativo(String aplicativo) {
		this.aplicativo = aplicativo;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	
}