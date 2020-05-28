package com.prismamp.consultas.api.model.entity.pagos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "upes_test")
public class Pago {
	
	@Id
	@Column (name = "id", columnDefinition = "SERIAL")
	private Long id;
	@Column (name = "FIID")
	private String banco;
	@Column (name = "TIPODOC")
	private String tipoDocumento;
	@Column (name = "NUMERODOC")
	private String numeroDocumento;
	@Column (name = "FECHAHORA", columnDefinition = "datetime")
	private Date fecha;
	@Column (name = "IDEMPRESA")
	private String idEmpresa;
	@Column (name = "IDCLIENTE")
	private String idCliente;
	@Column (name = "IMPORTE")
	private double importe;
	@Column (name = "MONEDA")
	private String moneda;
	@Column (name = "TIPOCUENTA")
	private String tipoDeCuenta;
	@Column (name = "NUMEROCUENTA")
	private String nroDeCuenta;
	@Column (name = "CANAL")
	private String canal;
	@Column (name = "LEYENDATICKET")
	private String leyendaTicket;
	@Column (name = "NUMEROCONTROL")
	private String numeroControl;
	@Column (name = "NUMEROSECUENCIA")
	private String numeroSecuencia;
	@Column (name = "anulado", columnDefinition = "tinyint(1)", nullable=true)
	private Boolean anulado;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getTipoDeCuenta() {
		return tipoDeCuenta;
	}
	public void setTipoDeCuenta(String tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}
	public String getNroDeCuenta() {
		return nroDeCuenta;
	}
	public void setNroDeCuenta(String nroDeCuenta) {
		this.nroDeCuenta = nroDeCuenta;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public String getLeyendaTicket() {
		return leyendaTicket;
	}
	public void setLeyendaTicket(String leyendaTicket) {
		this.leyendaTicket = leyendaTicket;
	}
	public String getNumeroControl() {
		return numeroControl;
	}
	public void setNumeroControl(String numeroControl) {
		this.numeroControl = numeroControl;
	}
	public String getNumeroSecuencia() {
		return numeroSecuencia;
	}
	public void setNumeroSecuencia(String numeroSecuencia) {
		this.numeroSecuencia = numeroSecuencia;
	}
	public Boolean isAnulado() {
		return anulado;
	}
	public void setAnulado(Boolean anulado) {
		this.anulado = anulado;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
