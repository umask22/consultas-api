package com.prismamp.consultas.api.rest.request;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ConsultaUltimosPagosRequest extends ConsultasBaseRequest {

	@XmlElement(required = true)
	private String idEmpresa;

	@XmlElement(required = false)
	private String idCliente;

	@XmlElement(required = false)
	private String tipoEmpresa;
	
	@XmlElement(required = true, defaultValue = "0")
	private Integer indiceLote;
	
	public Integer getIndiceLote() {
		return indiceLote;
	}

	public void setIndiceLote(Integer indiceLote) {
		this.indiceLote = indiceLote;
	}

	public String getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

}
