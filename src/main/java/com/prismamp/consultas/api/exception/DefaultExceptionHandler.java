package com.prismamp.consultas.api.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.jboss.resteasy.client.exception.ResteasyIOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prismamp.consultas.api.model.dto.ErrorDTO;
import com.prismamp.consultas.api.rest.filter.LoggingInterceptor;
import com.prismamp.consultas.api.service.MensajeErrorService;

@Provider
@Component
public class DefaultExceptionHandler implements ExceptionMapper<Exception>
{
	private static final Log logger = LogFactory.getLog(DefaultExceptionHandler.class);
	
	@Autowired
	protected MensajeErrorService mensajesErrorService;

	@Autowired
	LoggingInterceptor interceptor;

	public Response toResponse(Exception e)
	{
		Response response = null;
		if (e instanceof ResteasyIOException)
		{
			ErrorDTO error = mensajesErrorService.getError("C72");
			response = Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(error).type("application/json")
					.build();
		}
		if (e instanceof ConsultasApiException)
		{
			ConsultasApiException usuariosApiException = (ConsultasApiException) e;
			ErrorDTO error = mensajesErrorService.getError(usuariosApiException.getCodigo(), usuariosApiException.getBanco(),
					usuariosApiException.getOperacion());
			response = Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(error)
					.type("application/json").build();
		}
		else if (e instanceof MethodConstraintViolationException)
		{

			MethodConstraintViolationException validacionException = (MethodConstraintViolationException) e;
			// Obtiene el mensaje de la 1er validación que no pasó ( siempre
			// debería haber al menos una ).
			String codigoError = validacionException.getConstraintViolations().iterator().next().getMessage();

			ErrorDTO error = mensajesErrorService.getError(codigoError);
			response = Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(error).type("application/json")
					.build();
		}
		else
		{
			logger.error(e.getClass().getSimpleName() + "|" + e.getMessage(), e);
			ErrorDTO error = mensajesErrorService.getErrorGenerico();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(error)
					.type("application/json").build();
		}
		interceptor.postProcess(response);
		return response;
	}
}
