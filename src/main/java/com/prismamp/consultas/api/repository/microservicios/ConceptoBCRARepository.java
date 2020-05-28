package com.prismamp.consultas.api.repository.microservicios;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prismamp.consultas.api.model.entity.microservicios.Concepto;

public interface ConceptoBCRARepository extends JpaRepository<Concepto, Integer> {

	Concepto findOneByNumero(String numero);

	Concepto findOneByNombreCorto(String nombre);
	
	@Cacheable("conceptos")	
	List<Concepto> findAllByAplicativoOrderByOrdenAsc(String aplicativo);
	
//	@Cacheable("concepto")	
	Concepto findConceptoByAplicativoAndNombreCorto(String aplicativo, String nombreCorto);

	@Cacheable("concepto")	
	Concepto findConceptoByAplicativoAndNumero(String aplicativo, String codConcepto);
	
}