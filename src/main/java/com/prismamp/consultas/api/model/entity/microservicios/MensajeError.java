package com.prismamp.consultas.api.model.entity.microservicios;

import javax.persistence.Cacheable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "MensajeError")
public class MensajeError {

	@EmbeddedId
	private MensajeErrorPrimaryKeyCompuesta id;

	private String codigo;

	private String mensaje;

	private String severidad;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getSeveridad() {
		return severidad;
	}

	public void setSeveridad(String severidad) {
		this.severidad = severidad;
	}

	public MensajeErrorPrimaryKeyCompuesta getId() {
		return id;
	}

	public void setId(MensajeErrorPrimaryKeyCompuesta id) {
		this.id = id;
	}

}
