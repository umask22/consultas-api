package com.prismamp.consultas.api.rest;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.validation.ValidateRequest;
import org.json.simple.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.prismamp.consultas.api.exception.ConsultasApiException;
import com.prismamp.consultas.api.model.dto.ConsultaDeudasYAdhesionesDTO;
import com.prismamp.consultas.api.model.dto.ConsultaDisponibleDTO;
import com.prismamp.consultas.api.model.dto.ConsultaFacturasDTO;
import com.prismamp.consultas.api.model.dto.ErrorDTO;
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
import com.prismamp.consultas.api.rest.request.ConsultaTransferenciasMobileRequest;
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
import com.prismamp.consultas.api.service.ConsultasApiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Path("/rest/")
@Api(value = "consultas-api")
@ValidateRequest
public class ConsultasApiEndpoint {

	@Autowired
	private ConsultasApiService consultasApiService;

	@SuppressWarnings("unchecked")
	@POST
	@Path("/echo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Retorna el mensaje del usuario", notes = "Retorna el mensaje enviado por el usuario.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno exitoso del mensaje enviado por el usuario.") })
	public Response echo(
			@ApiParam(name = "mensaje", value = "Mensaje a retornar por el servicio.", required = true) String mensaje) {
		JSONObject respuestaJson = new JSONObject();
		respuestaJson.put("Mensaje Recibido", mensaje);
		return Response.status(Response.Status.OK).entity(respuestaJson.toString()).build();
	}
	
	@POST
	@Path("/consultarUltimosPagosPorUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Últimos Pagos por Usuario", notes = "Consulta los últimos pagos de un usuario, paginado.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = UltimosPagosPorUsuarioDTO.class),
			@ApiResponse(code = 400, message = "Error", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Error", response = ErrorDTO.class) })
	public Response consultarUltimosPagosPorUsuario(
			@ApiParam(name = "ultimosPagosPorUsuarioRequest", value = "Request para consultar últimos pagos", required = true)
			@Valid UltimosPagosPorUsuarioRequest request) throws ConsultasApiException
	{
		UltimosPagosPorUsuarioDTO response = consultasApiService.consultarUltimosPagosPorUsuario(request);
		return Response.status(Response.Status.OK).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/consultarFacturas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Consulta las facturas dado un idCliente y idEmpresa", notes = "Retorna las facturas del cliente.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ConsultaFacturasDTO.class),
			@ApiResponse(code = 400, message = "Error", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Error", response = ErrorDTO.class) })
	public Response consultarFacturas(
			@ApiParam(name = "consultaFacturasRequest", value = "Request para obtener las facturas", required = true)
			@Valid ConsultaFacturasRequest consultaFacturasRequest)
			throws ConsultasApiException {

		ConsultaFacturasDTO response = consultasApiService.consultarFacturas(consultaFacturasRequest);

		return Response.status(Response.Status.OK).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/consultarDeudas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Consulta las deudas y adhesiones del usuario", notes = "Retorna las deudas del cliente. Si se envía una \"I\" en msgBancoEspecial también retorna las adhesiones.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ConsultaDeudasYAdhesionesDTO.class),
			@ApiResponse(code = 400, message = "Error", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Error", response = ErrorDTO.class) })
	public Response consultarDeudas(
			@ApiParam(name = "consultaDeudasRequest", value = "Request para obtener las deudas y adhesiones", required = true)
			@Valid ConsultaDeudasRequest consultaDeudasRequest)
			throws Exception {

		ConsultaDeudasYAdhesionesDTO response = consultasApiService.consultarDeudas(consultaDeudasRequest);

		return Response.status(Response.Status.OK).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/consultarUltimosPagos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Consulta los últimos pagos del cliente", notes = "Retorna los últimos pagos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = UltimosPagosTicketDTO.class),
			@ApiResponse(code = 400, message = "Error", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Error", response = ErrorDTO.class) })
	public Response consultarUltimosPagos(
			@ApiParam(name = "consultaUltimosPagosRequest", value = "Request para obtener los últimos pagos. Se puede especificar si es de una empresa en particular setteando el idEmpresa, caso contrario dejarlo vacío", required = true) @Valid ConsultaUltimosPagosRequest consultaUltimosPagosRequest)
			throws Exception {
		UltimosPagosTicketDTO response = consultasApiService.consultarUltimosPagos(consultaUltimosPagosRequest);
		return Response.status(Response.Status.OK).entity(response).build();
	}

	@POST
	@Path("/consultarDisponible")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Consulta el disponible del usuario", notes = "Retorna el disponible del cliente.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ConsultaDisponibleDTO.class),
			@ApiResponse(code = 400, message = "Error", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Error", response = ErrorDTO.class) })
	public Response consultarDisponible(
			@ApiParam(name = "consultaDisponibleRequest", value = "Request para obtener el disponible", required = true) @Valid ConsultaDisponibleRequest consultaDisponibleRequest)
			throws Exception {
		ConsultaDisponibleDTO response = consultasApiService.consultarDisponible(consultaDisponibleRequest);
		return Response.status(Response.Status.OK).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/v1/debt_barcode_details/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Consulta una Deuda a partir de un Codigo de Barras", notes = "Consulta una Deuda a partir de un Codigo de Barras.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = DeudaCBCompaniesResponse.class),
			@ApiResponse(code = 400, message = "Error", response = ErrorDTO.class) })
	public Response deudaConCodigoDeBarras(
			@ApiParam(name = "consultaDeudaConCodigoDeBarrasRequest", value = "Request para obtener la deuda asociada al Codigo de Barras", required = true) DeudaCBRequest deudaCBRequest)
			throws Exception {
		DeudaCBCompaniesResponse response = consultasApiService.deudaConCodigoDeBarras(deudaCBRequest);
		return Response.status(Response.Status.OK).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/v1/debt_barcode_details/{company_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Consulta una Deuda a partir de un Codigo de Barras por Empresa", notes = "Consulta una Deuda a partir de un Codigo de Barras por Empresa.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = DeudaCBResponse.class),
			@ApiResponse(code = 400, message = "Error", response = ErrorDTO.class) })
	public Response deudaConCodigoDeBarrasPorEmpresa(
			@ApiParam(name = "consultaDeudaConCodigoDeBarrasPorEmpresaRequest", value = "Request para obtener la deuda asociada al Codigo de Barras por Empresa", required = true) DeudaCBRequest deudaCBRequest, @PathParam("company_id") String empresaId)
			throws Exception {
		DeudaCBResponse response = consultasApiService.deudaConCodigoDeBarrasPorEmpresa(deudaCBRequest, empresaId);
		return Response.status(Response.Status.OK).entity(response).type(MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Path("/consultarConceptos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Consulta conceptos disponibles para realizar una transferencia", notes = "Consulta conceptos disponibles para realizar una transferencia.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ConsultarConceptosResponse.class),
			@ApiResponse(code = 400, message = "Error", response = ErrorDTO.class) })
	public Response consultarConceptos(@Valid ConsultarConceptosRequest request) throws Exception {
		ConsultarConceptosResponse response = consultasApiService.consultarConceptos(request);
		return Response.status(Response.Status.OK).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/consultarConceptoPorNombreCorto")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Consulta concepto disponible por nombre corto", notes = "Consulta concepto disponible por nombre corto.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = Concepto.class),
			@ApiResponse(code = 400, message = "Error", response = ErrorDTO.class) })
	public Response consultarConceptoPorAplicativoYNombreCorto(@Valid ConsultarConceptoRequest request) throws Exception {
		Concepto response = consultasApiService.consultarConceptoPorNombreCorto(request);
		return Response.status(Response.Status.OK).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
	
	
	@POST
	@Path("/consultarTransferenciasRealizadas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Consulta transferencias usuario", notes = "Retorna transferencias realizadas por el usuario.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = TransferenciaRealizadaDTO.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "Error", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Error", response = ErrorDTO.class) })
	public Response consultarTransferenciasRealizadas(
			@ApiParam(name = "consultaDeudasRequest", value = "Request para obtener transferencias realizadas", required = true)
			@Valid ConsultaTransferenciasMobileRequest request)
			throws Exception {
		
		ConsultasBaseRequest baseRequest = new ConsultasBaseRequest();
		BeanUtils.copyProperties(request, baseRequest);
		baseRequest.setIp(request.getTokenSeguridad());
		List<TransferenciaRealizadaDTO> response = consultasApiService.consultarTransferenciasRealizadas(baseRequest);

		return Response.status(Response.Status.OK).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/consultarNombreConcepto/{codConcepto}")
	@ApiOperation(value = "Consulta nombre de concepto", notes = "Retorna nombre del concepto en base al codigo")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = Concepto.class),
			@ApiResponse(code = 400, message = "Error", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Error", response = ErrorDTO.class) })
	public Response consultarNombreConcepto(@PathParam("codConcepto") String codConcepto )
			throws Exception {
		Concepto response = consultasApiService.consultarNombreConcepto(codConcepto);
		
		return Response.status(Response.Status.OK).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/consultarDeudaEnLinea")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Consulta las deudas en linea", notes = "Consulta las deudas en linea.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ConsultaDeudaEnLineaResponse.class),
			@ApiResponse(code = 400, message = "Error", response = ErrorDTO.class) })
	public Response consultarDeudaEnLinea(@Valid ConsultaDeudaEnLineaRequest request) throws Exception {
		return Response.status(Response.Status.OK).entity(consultasApiService.consultarDeudaEnLinea(request)).type(MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/consultarUltimosMovimientos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Consulta ultimos movimientos del usuario", notes = "Retorna los ultimos movimientos realizados por el usuario.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok", response = ListaMovimientosDTO.class),
			@ApiResponse(code = 400, message = "Error", response = ErrorDTO.class),
			@ApiResponse(code = 500, message = "Error", response = ErrorDTO.class) })
	public Response consultarUltimosMovimientos(
			@ApiParam(name = "consultaDeudasRequest", value = "Request para obtener ultimos movimientos", required = true)
			@Valid UltimosMovimientosRequest request)
			throws Exception {
		ListaMovimientosDTO response = consultasApiService.consultarUltimosMovimientos(request);

		return Response.status(Response.Status.OK).entity(response).type(MediaType.APPLICATION_JSON).build();
	}
	
}