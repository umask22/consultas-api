package com.prismamp.consultas.api.rest.request;


public class ConsultaDeudaEnLineaRequest extends ConsultaDeudasRequest {
	
	private String idEmpresa;
	
	private String idCliente;
	
	private String subCodigo;

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

	public String getSubCodigo() {
		return subCodigo;
	}

	public void setSubCodigo(String subCodigo) {
		this.subCodigo = subCodigo;
	}
		
}
