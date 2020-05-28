package com.prismamp.consultas.api.model.dto;

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
public class ConsultaDeudasYAdhesionesDTO extends BaseObject {
    @XmlElementWrapper
    private List<DeudaInfoDTO> deudas;

    @XmlElementWrapper
    private List<AdhesionServicioDTO> adhesiones;

    public List<DeudaInfoDTO> getDeudas() {
	return deudas;
    }

    public void setDeudas(List<DeudaInfoDTO> deudas) {
	this.deudas = deudas;
    }

    public List<AdhesionServicioDTO> getAdhesiones() {
	return adhesiones;
    }

    public void setAdhesiones(List<AdhesionServicioDTO> adhesiones) {
	this.adhesiones = adhesiones;
    }

}