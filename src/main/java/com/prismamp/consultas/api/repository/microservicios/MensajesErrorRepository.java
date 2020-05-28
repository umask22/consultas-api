package com.prismamp.consultas.api.repository.microservicios;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prismamp.consultas.api.model.entity.microservicios.MensajeError;
import com.prismamp.consultas.api.model.entity.microservicios.MensajeErrorPrimaryKeyCompuesta;

public interface MensajesErrorRepository extends JpaRepository<MensajeError, MensajeErrorPrimaryKeyCompuesta> {

	@Cacheable("rechazos")
	MensajeError findByIdRcAndIdBancoAndIdOperacion(String rc, String banco, String operacion);

}
