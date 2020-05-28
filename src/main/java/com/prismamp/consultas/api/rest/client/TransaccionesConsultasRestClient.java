package com.prismamp.consultas.api.rest.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientResponse;

import com.prismamp.consultas.api.rest.request.ConsultaDeudaConCodigoDeBarrasRequest;
import com.prismamp.consultas.api.rest.request.ConsultaDeudaEnLineaRequest;
import com.prismamp.consultas.api.rest.request.ConsultaDeudasRequest;
import com.prismamp.consultas.api.rest.request.ConsultaDisponibleRequest;
import com.prismamp.consultas.api.rest.request.ConsultaFacturasRequest;
import com.prismamp.consultas.api.rest.request.ConsultaUltimosPagosRequest;
import com.prismamp.consultas.api.rest.request.ConsultasBaseRequest;
import com.prismamp.consultas.api.rest.request.UltimosMovimientosRequest;

@Path("consultas/")
@SuppressWarnings("rawtypes")
public interface TransaccionesConsultasRestClient
{
	@POST
	@Path("consultarDeudas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse consultarDeudas(ConsultaDeudasRequest consultaDeudasRequest);

	@POST
	@Path("consultarUltimosPagos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse consultarUltimosPagos(ConsultaUltimosPagosRequest consultaUltimosPagosRequest);

	@POST
	@Path("consultarDisponible")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse consultarDisponible(ConsultaDisponibleRequest consultaDisponibleRequest);

	@POST
	@Path("consultarFacturas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse consultarFacturas(ConsultaFacturasRequest consultaFacturasRequest);
	
	@POST
	@Path("consultarDeudaConCodigoDeBarras")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse consultarDeudaConCodigoDeBarras(ConsultaDeudaConCodigoDeBarrasRequest consultaFacturasRequest);
	
	@POST
	@Path("consultarUltimasTransferenciasRealizadas")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse consultarUltimasTransferenciasRealizadas(ConsultasBaseRequest consultaFacturasRequest);
	
	@POST
	@Path("consultarDeudaEnLinea")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse consultarDeudaEnLinea(ConsultaDeudaEnLineaRequest request);

	@POST
	@Path("consultarUltimosMovimientos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse consultarUltimosMovimientos(UltimosMovimientosRequest ultimosMovimientosRuequest);

}
