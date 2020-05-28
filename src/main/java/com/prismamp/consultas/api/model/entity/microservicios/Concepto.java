package com.prismamp.consultas.api.model.entity.microservicios;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Table(name = "ConceptoBCRA")
public class Concepto {
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "numero", unique = true, nullable = false)
	private String numero;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "nombre_corto", nullable = false)
	private String nombreCorto;
	
	@Column(name = "aplicativo", nullable = false)
	private String aplicativo;
	
	@Column(name = "solo_persona_juridica", nullable = false)
	private Boolean soloPersonaJuridica;

	@Column(name = "orden", nullable = false)
	private Integer orden;
	
	@OneToOne
	@JoinColumn (name = "id_mensaje_ddjj", nullable = true )
	private ConceptoMensajeDDJJ mensajeDDJJ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getAplicativo() {
		return aplicativo;
	}

	public void setAplicativo(String aplicativo) {
		this.aplicativo = aplicativo;
	}

	public Boolean getSoloPersonaJuridica() {
		return soloPersonaJuridica;
	}

	public void setSoloPersonaJuridica(Boolean soloPersonaJuridica) {
		this.soloPersonaJuridica = soloPersonaJuridica;
	}

	public ConceptoMensajeDDJJ getMensajeDDJJ() {
		return mensajeDDJJ;
	}

	public void setMensajeDDJJ(ConceptoMensajeDDJJ mensajeDDJJ) {
		this.mensajeDDJJ = mensajeDDJJ;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	
}
