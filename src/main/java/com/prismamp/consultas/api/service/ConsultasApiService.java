package com.prismamp.consultas.api.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prismamp.consultas.api.exception.ConsultasApiException;
import com.prismamp.consultas.api.model.dto.ConsultaDeudasYAdhesionesDTO;
import com.prismamp.consultas.api.model.dto.ConsultaDisponibleDTO;
import com.prismamp.consultas.api.model.dto.ConsultaFacturasDTO;
import com.prismamp.consultas.api.model.dto.ListaMovimientosDTO;
import com.prismamp.consultas.api.model.dto.TransferenciaRealizadaDTO;
import com.prismamp.consultas.api.model.dto.UltimosPagosPorUsuarioDTO;
import com.prismamp.consultas.api.model.dto.UltimosPagosTicketDTO;
import com.prismamp.consultas.api.model.entity.microservicios.Concepto;
import com.prismamp.consultas.api.rest.request.ConsultaDeudaConCodigoDeBarrasRequest;
import com.prismamp.consultas.api.rest.request.ConsultaDeudaEnLineaRequest;
import com.prismamp.consultas.api.rest.request.ConsultaDeudasRequest;
import com.prismamp.consultas.api.rest.request.ConsultaDisponibleRequest;
import com.prismamp.consultas.api.rest.request.ConsultaFacturasRequest;
import com.prismamp.consultas.api.rest.request.ConsultaUltimosPagosRequest;
import com.prismamp.consultas.api.rest.request.ConsultarConceptoRequest;
import com.prismamp.consultas.api.rest.request.ConsultarConceptosRequest;
import com.prismamp.consultas.api.rest.request.ConsultasBaseRequest;
import com.prismamp.consultas.api.rest.request.DeudaCBRequest;
import com.prismamp.consultas.api.rest.request.UltimosMovimientosRequest;
import com.prismamp.consultas.api.rest.request.UltimosPagosPorUsuarioRequest;
import com.prismamp.consultas.api.rest.response.ConsultaDeudaConCodigoDeBarrasResponse;
import com.prismamp.consultas.api.rest.response.ConsultaDeudaEnLineaResponse;
import com.prismamp.consultas.api.rest.response.ConsultarConceptosResponse;
import com.prismamp.consultas.api.rest.response.DeudaCBCompaniesResponse;
import com.prismamp.consultas.api.rest.response.DeudaCBResponse;

public interface ConsultasApiService

{
	public UltimosPagosPorUsuarioDTO consultarUltimosPagosPorUsuario(UltimosPagosPorUsuarioRequest request) throws ConsultasApiException;
	
	public ConsultaFacturasDTO consultarFacturas(ConsultaFacturasRequest consultaFacturasRequest) throws ConsultasApiException;
	
	public ConsultaDeudasYAdhesionesDTO consultarDeudas(ConsultaDeudasRequest consultaDeudasRequest) throws ConsultasApiException;
	
	public UltimosPagosTicketDTO consultarUltimosPagos(ConsultaUltimosPagosRequest consultaUltimosPagosRequest) throws ConsultasApiException;

	public ConsultaDisponibleDTO consultarDisponible(ConsultaDisponibleRequest consultaDisponibleRequest) throws ConsultasApiException;

	public DeudaCBCompaniesResponse deudaConCodigoDeBarras(DeudaCBRequest request) throws ConsultasApiException, JsonProcessingException, IOException;
	
	public DeudaCBResponse deudaConCodigoDeBarrasPorEmpresa(DeudaCBRequest request, String empresaId) throws ConsultasApiException, JsonProcessingException, IOException;
	
	public ConsultarConceptosResponse consultarConceptos(ConsultarConceptosRequest request) throws ConsultasApiException;
	
	public Concepto consultarConceptoPorNombreCorto(ConsultarConceptoRequest request) throws ConsultasApiException;

	public List<TransferenciaRealizadaDTO> consultarTransferenciasRealizadas(ConsultasBaseRequest request) throws ConsultasApiException;

	public Concepto consultarNombreConcepto(String codConcepto) throws ConsultasApiException;

	public ConsultaDeudaEnLineaResponse consultarDeudaEnLinea(ConsultaDeudaEnLineaRequest request) throws ConsultasApiException;

	public ListaMovimientosDTO consultarUltimosMovimientos(UltimosMovimientosRequest request) throws ConsultasApiException;

}

