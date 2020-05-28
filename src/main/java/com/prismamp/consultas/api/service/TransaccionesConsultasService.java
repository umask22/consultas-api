package com.prismamp.consultas.api.service;

import java.util.List;

import com.prismamp.consultas.api.exception.ConsultasApiException;
import com.prismamp.consultas.api.model.dto.ConsultaDeudasDTO;
import com.prismamp.consultas.api.model.dto.ConsultaDisponibleDTO;
import com.prismamp.consultas.api.model.dto.ConsultaFacturasDTO;
import com.prismamp.consultas.api.model.dto.ListaMovimientosDTO;
import com.prismamp.consultas.api.model.dto.TransferenciaRealizadaDTO;
import com.prismamp.consultas.api.model.dto.UltimosPagosDTO;
import com.prismamp.consultas.api.rest.request.ConsultaDeudaConCodigoDeBarrasRequest;
import com.prismamp.consultas.api.rest.request.ConsultaDeudaEnLineaRequest;
import com.prismamp.consultas.api.rest.request.ConsultaDeudasRequest;
import com.prismamp.consultas.api.rest.request.ConsultaDisponibleRequest;
import com.prismamp.consultas.api.rest.request.ConsultaFacturasRequest;
import com.prismamp.consultas.api.rest.request.ConsultaUltimosPagosRequest;
import com.prismamp.consultas.api.rest.request.ConsultasBaseRequest;
import com.prismamp.consultas.api.rest.request.UltimosMovimientosRequest;
import com.prismamp.consultas.api.rest.response.ConsultaDeudaConCodigoDeBarrasResponse;
import com.prismamp.consultas.api.rest.response.ConsultaDeudaEnLineaResponse;

public interface TransaccionesConsultasService 
{
	public ConsultaDeudasDTO consultarDeudas(ConsultaDeudasRequest consultaDeudasRequest) throws ConsultasApiException;

	public UltimosPagosDTO consultarUltimosPagos(ConsultaUltimosPagosRequest consultaUltimosPagosRequest) throws ConsultasApiException;

	public ConsultaDisponibleDTO consultarDisponible(ConsultaDisponibleRequest consultaDisponibleRequest) throws ConsultasApiException;

	public ConsultaFacturasDTO consultarFacturas(ConsultaFacturasRequest consultaFacturasRequest) throws ConsultasApiException;

	public ConsultaDeudaConCodigoDeBarrasResponse consultarDeudaConCodigoDeBarras(ConsultaDeudaConCodigoDeBarrasRequest request) throws ConsultasApiException;
	
	public List<TransferenciaRealizadaDTO> consultarTransferenciasRealizadas(ConsultasBaseRequest request) throws ConsultasApiException;
	
	public ConsultaDeudaEnLineaResponse consultarDeudaEnLinea(ConsultaDeudaEnLineaRequest request) throws ConsultasApiException;

	public ListaMovimientosDTO consultarUltimosMovimientos(UltimosMovimientosRequest request) throws ConsultasApiException;
}