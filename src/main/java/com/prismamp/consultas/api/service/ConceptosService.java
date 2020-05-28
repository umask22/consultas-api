package com.prismamp.consultas.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prismamp.consultas.api.model.entity.microservicios.Concepto;
import com.prismamp.consultas.api.repository.microservicios.ConceptoBCRARepository;

@Service
public class ConceptosService {

	@Autowired
	private ConceptoBCRARepository conceptosRepository;
	
	public List<Concepto> consultarConceptos() {
		return conceptosRepository.findAll();
	}
	
	public List<Concepto> consultarConceptosByAplicativo(String aplicativo) {
		return conceptosRepository.findAllByAplicativoOrderByOrdenAsc(aplicativo);
	}
	
	public Concepto consultarConceptosByAplicativoAndNombreCorto(String aplicativo, String nombreCorto) {
		return conceptosRepository.findConceptoByAplicativoAndNombreCorto(aplicativo, nombreCorto);
	}

	public Concepto consultarConceptosByAplicativoAndCodigo(String aplicativo, String codConcepto) {
		return conceptosRepository.findConceptoByAplicativoAndNumero(aplicativo, codConcepto);
	}
}
