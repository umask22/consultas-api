package com.prismamp.consultas.api.repository.pagos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prismamp.consultas.api.model.entity.pagos.Pago;

public interface PagosRepository extends JpaRepository<Pago, Long> {

	List<Pago> findByBancoAndTipoDocumentoAndNumeroDocumento(String fiid, String tipoDoc, String nroDoc, Pageable pageable);
	
}
