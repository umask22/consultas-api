package com.prismamp.consultas.api.rest.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.prismamp.consultas.api.model.dto.DeudaInfoConCBDTO;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaDeudaConCodigoDeBarrasResponse
{
	@XmlElement
	private List<String> idEmpresas;
	
	@XmlElement
	private List<String> nombreEmpresas;
	
	@XmlElement
	private DeudaInfoConCBDTO deudaConCB;

	public List<String> getIdEmpresas()
	{
		return idEmpresas;
	}

	public void setIdEmpresas(List<String> idEmpresas)
	{
		this.idEmpresas = idEmpresas;
	}
	
	public List<String> getNombreEmpresas() {
		return nombreEmpresas;
	}
	
	public void setNombreEmpresas(List<String> nombreEmpresas) {
		this.nombreEmpresas = nombreEmpresas;
	}

	public DeudaInfoConCBDTO getDeudaConCB()
	{
		return deudaConCB;
	}

	public void setDeudaConCB(DeudaInfoConCBDTO deudaConCB)
	{
		this.deudaConCB = deudaConCB;
	}
}
