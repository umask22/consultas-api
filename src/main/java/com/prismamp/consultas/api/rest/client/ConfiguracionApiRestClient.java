package com.prismamp.consultas.api.rest.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientResponse;

import com.prismamp.consultas.api.exception.ConsultasApiException;

@Path("/")
@SuppressWarnings("rawtypes")
public interface ConfiguracionApiRestClient {

	@GET
	@Path("services/bank")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse getBanco(@QueryParam("code_bcra") String bankCode) throws ConsultasApiException;
	
	@GET
	@Path("services/document_type")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse getDocumentTypeId(@QueryParam("document_type") String documentType) throws ConsultasApiException;

}
