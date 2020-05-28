package com.prismamp.consultas.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.util.GenericType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.prismamp.consultas.api.exception.ConsultasApiException;
import com.prismamp.consultas.api.model.Operacion;
import com.prismamp.consultas.api.model.dto.ConsultaDeudasDTO;
import com.prismamp.consultas.api.model.dto.ConsultaDisponibleDTO;
import com.prismamp.consultas.api.model.dto.ConsultaFacturasDTO;
import com.prismamp.consultas.api.model.dto.ErrorDTO;
import com.prismamp.consultas.api.model.dto.ListaMovimientosDTO;
import com.prismamp.consultas.api.model.dto.TransferenciaRealizadaDTO;
import com.prismamp.consultas.api.model.dto.UltimosPagosDTO;
import com.prismamp.consultas.api.rest.client.TransaccionesConsultasRestClient;
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
import com.prismamp.consultas.api.service.TransaccionesConsultasService;
import com.prismamp.consultas.api.util.Constantes;
import com.prismamp.consultas.api.util.rest.RestClientFactory;
import com.prismamp.consultas.api.util.rest.RestUtil;

@Service
@PropertySource("classpath:consultas-api.properties")
public class TransaccionesConsultasServiceImpl implements TransaccionesConsultasService {

	private TransaccionesConsultasRestClient client = null;

	@Autowired
	private Environment env;

	private TransaccionesConsultasRestClient getClient() throws ConsultasApiException {
		if (client == null) {
			initClient();
		}
		return client;
	}

	private void initClient() {

		client = RestClientFactory.crear(env.getProperty("transaccionesB24.url"),
				env.getProperty("transaccionesB24.connectiontimeout", Integer.class),
				env.getProperty("transaccionesB24.receivetimeout", Integer.class), TransaccionesConsultasRestClient.class);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ConsultaDeudasDTO consultarDeudas(ConsultaDeudasRequest request) throws ConsultasApiException {

		ClientResponse response = getClient().consultarDeudas(request);
		ConsultaDeudasDTO consultaResponse = RestUtil.obtenerDTO(response, ConsultaDeudasDTO.class, request.getFiid(),
				Operacion.CONSULTA_DEUDAS.toString());

		return consultaResponse;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public ConsultaFacturasDTO consultarFacturas(ConsultaFacturasRequest consultaFacturasRequest)
			throws ConsultasApiException {
		ClientResponse response = getClient().consultarFacturas(consultaFacturasRequest);
		ConsultaFacturasDTO consultaResponse = RestUtil.obtenerDTO(response, ConsultaFacturasDTO.class, consultaFacturasRequest.getFiid(),
				Operacion.CONSULTA_DEUDAS.toString());
		return consultaResponse;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public UltimosPagosDTO consultarUltimosPagos(ConsultaUltimosPagosRequest request) throws ConsultasApiException {

		ClientResponse response = getClient().consultarUltimosPagos(request);
		UltimosPagosDTO consultaResponse = RestUtil.obtenerDTO(response, UltimosPagosDTO.class, request.getFiid(),
				Operacion.ULTIMOS_PAGOS.toString());

		return consultaResponse;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ConsultaDisponibleDTO consultarDisponible(ConsultaDisponibleRequest request) throws ConsultasApiException {

		ClientResponse response = getClient().consultarDisponible(request);
		ConsultaDisponibleDTO consultaResponse = RestUtil.obtenerDTO(response, ConsultaDisponibleDTO.class,
				request.getFiid(), Operacion.CONSULTA_DISPONIBLE.toString());

		return consultaResponse;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public ConsultaDeudaConCodigoDeBarrasResponse consultarDeudaConCodigoDeBarras(ConsultaDeudaConCodigoDeBarrasRequest request) throws ConsultasApiException {

		ClientResponse response = getClient().consultarDeudaConCodigoDeBarras(request);
		ConsultaDeudaConCodigoDeBarrasResponse consultaResponse = RestUtil.obtenerDTO(response, ConsultaDeudaConCodigoDeBarrasResponse.class,
				request.getFiid(), Operacion.CONSULTA_DEUDAS_CON_CB.toString());

		return consultaResponse;
	}

	@Override
	public List<TransferenciaRealizadaDTO> consultarTransferenciasRealizadas(ConsultasBaseRequest request) throws ConsultasApiException {
		ClientResponse response = getClient().consultarUltimasTransferenciasRealizadas(request);
		List<TransferenciaRealizadaDTO> resultado;
		if(response.getStatus() == ClientResponse.Status.OK.getStatusCode())
		{
			GenericType<List<TransferenciaRealizadaDTO>> gType = new GenericType<List<TransferenciaRealizadaDTO>>(){}; 
			List<TransferenciaRealizadaDTO> transferencias = new ArrayList<TransferenciaRealizadaDTO>(); 
			transferencias=(List<TransferenciaRealizadaDTO>) (response.getEntity(gType)); 
			resultado = transferencias;
		}
		else
		{	
			ErrorDTO errorDTO = (ErrorDTO)response.getEntity(ErrorDTO.class);
			throw new ConsultasApiException(errorDTO);
		}
		
		return resultado;
	}

	@Override
	public ConsultaDeudaEnLineaResponse consultarDeudaEnLinea(ConsultaDeudaEnLineaRequest request) throws ConsultasApiException {
		
		ClientResponse response = getClient().consultarDeudaEnLinea(request);
		ConsultaDeudaEnLineaResponse responseApi = new ConsultaDeudaEnLineaResponse();
		if(response.getStatus() == ClientResponse.Status.OK.getStatusCode()) {
			GenericType<ConsultaDeudaEnLineaResponse> gType = new GenericType<ConsultaDeudaEnLineaResponse>(){};
			return responseApi = (ConsultaDeudaEnLineaResponse) response.getEntity(gType);

		} else {
			ErrorDTO errorDTO = (ErrorDTO)response.getEntity(ErrorDTO.class);
			throw new ConsultasApiException(errorDTO);
		}
	}
		

	@SuppressWarnings("rawtypes")
	@Override
	public ListaMovimientosDTO consultarUltimosMovimientos(UltimosMovimientosRequest request)
			throws ConsultasApiException {
		if(Constantes.CANAL_MOBILE.equals(request.getCanal())) {
			request.setIp(request.getTokenSeguridad());
		}
		ClientResponse response = getClient().consultarUltimosMovimientos(request);
		ListaMovimientosDTO result = RestUtil.obtenerDTO(response, ListaMovimientosDTO.class, request.getFiid(), Operacion.ULTIMOS_MOVIMIENTOS.toString());
		return result;
	}
	
}