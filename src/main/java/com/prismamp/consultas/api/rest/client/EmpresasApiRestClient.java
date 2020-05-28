package com.prismamp.consultas.api.rest.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientResponse;

import com.prismamp.consultas.api.exception.ConsultasApiException;
import com.sun.mail.iap.Response;

@Path("v2/")
@SuppressWarnings("rawtypes")
public interface EmpresasApiRestClient {

	@GET
	@Path("{bank_id}/categories/any/companies/{company_id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ClientResponse getCompany(@PathParam("bank_id") String bankId, @PathParam("company_id") String companyId);

}
