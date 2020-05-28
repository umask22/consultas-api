package com.prismamp.consultas.api.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prismamp.consultas.api.exception.ConsultasApiException;
import com.prismamp.consultas.api.model.comparator.DeudaInfoComparator;
import com.prismamp.consultas.api.model.dto.AdhesionServicioDTO;
import com.prismamp.consultas.api.model.dto.CompanyDTO;
import com.prismamp.consultas.api.model.dto.ConsultaDeudasDTO;
import com.prismamp.consultas.api.model.dto.ConsultaDeudasYAdhesionesDTO;
import com.prismamp.consultas.api.model.dto.ConsultaDisponibleDTO;
import com.prismamp.consultas.api.model.dto.ConsultaFacturasDTO;
import com.prismamp.consultas.api.model.dto.DeudaInfoDTO;
import com.prismamp.consultas.api.model.dto.FacturaDTO;
import com.prismamp.consultas.api.model.dto.ListaMovimientosDTO;
import com.prismamp.consultas.api.model.dto.PagoInfoDTO;
import com.prismamp.consultas.api.model.dto.TransferenciaRealizadaDTO;
import com.prismamp.consultas.api.model.dto.UltimosPagosDTO;
import com.prismamp.consultas.api.model.dto.UltimosPagosPorUsuarioDTO;
import com.prismamp.consultas.api.model.dto.UltimosPagosTicketDTO;
import com.prismamp.consultas.api.model.entity.microservicios.Concepto;
import com.prismamp.consultas.api.model.mapper.RequestMapper;
import com.prismamp.consultas.api.model.mapper.ResponseMapper;
import com.prismamp.consultas.api.model.mapper.UltimoPagoMapper;
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
import com.prismamp.consultas.api.rest.response.CompanyResponse;
import com.prismamp.consultas.api.rest.response.ConsultaDeudaConCodigoDeBarrasResponse;
import com.prismamp.consultas.api.rest.response.ConsultaDeudaEnLineaResponse;
import com.prismamp.consultas.api.rest.response.ConsultarConceptosResponse;
import com.prismamp.consultas.api.rest.response.DeudaCBCompaniesResponse;
import com.prismamp.consultas.api.rest.response.DeudaCBResponse;
import com.prismamp.consultas.api.service.ConceptosService;
import com.prismamp.consultas.api.service.ConfiguracionApiService;
import com.prismamp.consultas.api.service.ConsultasApiService;
import com.prismamp.consultas.api.service.EmpresaApiService;
import com.prismamp.consultas.api.service.TransaccionesConsultasService;

@Service
public class ConsultasApiServiceImpl implements ConsultasApiService
{
//	@Autowired
//	private PagosRepository pagosRepository;

	@Autowired
	TransaccionesConsultasService transaccionesConsultasService;
	
	@Autowired
	ConceptosService conceptosService;
	
	@Autowired
	EmpresaApiService empresaApiService;
	
	@Autowired
	ConfiguracionApiService configuracionApiService;
	
	@Autowired
	UltimoPagoMapper ultimoPagoMapper;

	public static final String FACTURA_ANUAL = "A";
	
	private static final String APLICATIVO_DFLT = "CONSULTAS";
	
	private static final String BANK_ID = "DEMO"; //DEMO: IdBank para Banelco || TPGO: IdBank para Market
	
	@Override
	public ConsultaFacturasDTO consultarFacturas(ConsultaFacturasRequest consultaFacturasRequest) throws ConsultasApiException
	{
		ConsultaFacturasDTO consultaFacturasDTO = transaccionesConsultasService.consultarFacturas(consultaFacturasRequest);
		
		for (FacturaDTO facturaDTO : consultaFacturasDTO.getFacturas())
		{
			if(FACTURA_ANUAL.equals(facturaDTO.getVtoPagoAutomatico()))
			{
				facturaDTO.setAnual(true);
			}
		}
		
		return consultaFacturasDTO;
	}

	@Override
	public ConsultaDeudasYAdhesionesDTO consultarDeudas(ConsultaDeudasRequest consultaDeudasRequest) throws ConsultasApiException
	{

		ConsultaDeudasDTO consultaDeudasDTO = transaccionesConsultasService.consultarDeudas(consultaDeudasRequest);

		List<DeudaInfoDTO> listadeudasValidas = new ArrayList<DeudaInfoDTO>();
		for (DeudaInfoDTO deuda : consultaDeudasDTO.getDeudasPendientes())
		{
			if (deuda.getImporte() > 0)
			{
				if(FACTURA_ANUAL.equals(deuda.getPagoRecurrente()))
				{
					deuda.setAnual(true);
				}
				listadeudasValidas.add(deuda);
			}
		}

		List<AdhesionServicioDTO> listaAdhesiones = new ArrayList<AdhesionServicioDTO>();
		for (DeudaInfoDTO deuda : consultaDeudasDTO.getDeudasPendientes())
		{
			AdhesionServicioDTO adhesionServicio = new AdhesionServicioDTO();
			adhesionServicio.setIdCliente(deuda.getIdCliente());
			adhesionServicio.setIdEmpresa(deuda.getIdEmpresa());
			adhesionServicio.setDescripcion(deuda.getDescripcionUsuario());
			if (!listaAdhesiones.contains(adhesionServicio))
			{
				listaAdhesiones.add(adhesionServicio);
			}
		}

		Collections.sort(listadeudasValidas, new DeudaInfoComparator());

		ConsultaDeudasYAdhesionesDTO response = new ConsultaDeudasYAdhesionesDTO();
		response.setAdhesiones(listaAdhesiones);
		response.setDeudas(listadeudasValidas);
		return response;
	}

	@Override
	public UltimosPagosPorUsuarioDTO consultarUltimosPagosPorUsuario(UltimosPagosPorUsuarioRequest request)
			throws ConsultasApiException
	{
		/*
		List<Pago> pagos = new ArrayList<Pago>();
		try {
			pagos = pagosRepository.findByBancoAndTipoDocumentoAndNumeroDocumento(request.getFiid(),request.getTipoDocumento(),request.getNroDocumento(), new PageRequest(Integer.parseInt(request.getNroPagina()), 13, Direction.DESC, "fecha"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (pagos != null)
		{
			UltimosPagosPorUsuarioDTO ultimosPagosDTO = new UltimosPagosPorUsuarioDTO();
			List<UltimoPagoInfoDTO> upisDTO = new ArrayList<UltimoPagoInfoDTO>();
			
			ultimosPagosDTO.setIdOperacion(null);
			ultimosPagosDTO.setTimeIn(null);
			ultimosPagosDTO.setTipoConsulta(null);
			
			if(pagos.size() < 13)
				ultimosPagosDTO.setSecuencia(99);
			else
				ultimosPagosDTO.setSecuencia(Integer.parseInt(request.getNroPagina()) + 1);
				
			UltimoPagoInfoDTO upiDTO = null;
			AccountDTO account = null;
			
			for(Pago pago : pagos)
			{
				upiDTO  = new UltimoPagoInfoDTO();
				account = new AccountDTO();
				
				account.setAmount(0);
				account.setCtaEspecial(false);
				account.setCurrency(pago.getMoneda());
				account.setIntereses(0);
				account.setLimite(0);
				account.setNumber(pago.getNroDeCuenta());
				account.setType(pago.getTipoDeCuenta());
				//anulado no se usa por ahora
				upiDTO.setAnulado(false);
				upiDTO.setFiid(pago.getBanco());
				upiDTO.setFechaPago((Date)pago.getFecha());
				upiDTO.setCorpId(pago.getIdEmpresa());
				upiDTO.setIdCliente(pago.getIdCliente());
				upiDTO.setImporte(pago.getImporte());
				upiDTO.setMoneda(Integer.parseInt(pago.getMoneda()));
				upiDTO.setCanal(pago.getCanal());
				upiDTO.setLeyenda(pago.getLeyendaTicket());
				upiDTO.setNroControl(pago.getNumeroControl());
				
				upiDTO.setCuenta(account);
				upisDTO.add(upiDTO);
				ultimosPagosDTO.setPagos(upisDTO);
			}
			return ultimosPagosDTO;
		}
		else
		{
//			return new UltimosPagosPorUsuarioDTO(CODIGO_ERROR_DEFAULT, MENSAJE_ERROR_DEFAULT);
			return null;
		}
		*/
		throw new ConsultasApiException("C99", "Method not yet implemented");
	}

	@Override
	public UltimosPagosTicketDTO consultarUltimosPagos(ConsultaUltimosPagosRequest consultaUltimosPagosRequest) throws ConsultasApiException
	{
		UltimosPagosDTO upDTO = transaccionesConsultasService.consultarUltimosPagos(consultaUltimosPagosRequest);
		UltimosPagosTicketDTO uptDTO = new UltimosPagosTicketDTO();
		for (PagoInfoDTO piDTO : upDTO.getPagos())
		{
			uptDTO.getPagos().add(ultimoPagoMapper.convert(piDTO));
		}
		uptDTO.setIndiceLote(upDTO.getIndiceLote());
		return uptDTO;
	}

	@Override
	public ConsultaDisponibleDTO consultarDisponible(ConsultaDisponibleRequest consultaDisponibleRequest) throws ConsultasApiException
	{
		return transaccionesConsultasService.consultarDisponible(consultaDisponibleRequest);
	}
	
	@Override
	public DeudaCBCompaniesResponse deudaConCodigoDeBarras(DeudaCBRequest request) throws ConsultasApiException {
		String documentTypeId = configuracionApiService.getDocumentTypeId(request.getClient().getDocument_type());
		request.getClient().setDocument_type(documentTypeId);
		
		String fiid = configuracionApiService.getBanco(request.getClient().getBank_id()).getFiid();
		request.getClient().setBank_id(fiid);
		
		ConsultaDeudaConCodigoDeBarrasRequest requestTransacciones = RequestMapper.map(request);
		ConsultaDeudaConCodigoDeBarrasResponse responseTransacciones = transaccionesConsultasService.consultarDeudaConCodigoDeBarras(requestTransacciones);
		
		DeudaCBCompaniesResponse response = ResponseMapper.mapOne(responseTransacciones);
		
		if(response.getCompanies().size() == 1) {
			CompanyResponse companyResponse = empresaApiService.getCompany(BANK_ID, response.getCompanies().get(0).getCompany_id());
			CompanyDTO company = ResponseMapper.mapCompany(companyResponse);
			response.getInovice().setAdditionalData(companyResponse.getAdditional_data());
			response.setCompany(company);	
		}
		
		return response;
	}
	
	@Override
	public DeudaCBResponse deudaConCodigoDeBarrasPorEmpresa(DeudaCBRequest request, String empresaId) throws ConsultasApiException {
		String documentTypeId = configuracionApiService.getDocumentTypeId(request.getClient().getDocument_type());
		request.getClient().setDocument_type(documentTypeId);
		
		String fiid = configuracionApiService.getBanco(request.getClient().getBank_id()).getFiid();
		request.getClient().setBank_id(fiid);
		
		ConsultaDeudaConCodigoDeBarrasRequest requestTransacciones = RequestMapper.map(request);
		requestTransacciones.setIdEmpresa(empresaId);
		ConsultaDeudaConCodigoDeBarrasResponse responseTransacciones = transaccionesConsultasService.consultarDeudaConCodigoDeBarras(requestTransacciones);
		
		DeudaCBResponse response = ResponseMapper.mapTwo(responseTransacciones);
		
		CompanyResponse companyResponse = empresaApiService.getCompany(BANK_ID, empresaId);
		CompanyDTO company = ResponseMapper.mapCompany(companyResponse);
		response.getInovice().setAdditionalData(companyResponse.getAdditional_data());
		response.setCompany(company);
		
		return response;
	}
	
	@Override 	
	public ConsultarConceptosResponse consultarConceptos(ConsultarConceptosRequest request) throws ConsultasApiException {
		ConsultarConceptosResponse response = new ConsultarConceptosResponse();
		response.setConceptos(conceptosService.consultarConceptosByAplicativo(request.getAplicativo()));
		
		return response;
	}

	@Override
	public Concepto consultarConceptoPorNombreCorto(ConsultarConceptoRequest request) throws ConsultasApiException {
		return conceptosService.consultarConceptosByAplicativoAndNombreCorto(request.getAplicativo(), request.getNombreCorto());
	}

	@Override
	public List<TransferenciaRealizadaDTO> consultarTransferenciasRealizadas(ConsultasBaseRequest request)
			throws ConsultasApiException {
		return transaccionesConsultasService.consultarTransferenciasRealizadas(request);
	}

	@Override
	public Concepto consultarNombreConcepto(String codConcepto) throws ConsultasApiException {
		return conceptosService.consultarConceptosByAplicativoAndCodigo(APLICATIVO_DFLT, codConcepto);
	}

	@Override

	public ConsultaDeudaEnLineaResponse consultarDeudaEnLinea(ConsultaDeudaEnLineaRequest request) throws ConsultasApiException {
		return transaccionesConsultasService.consultarDeudaEnLinea(request);
	}

	@Override
	public ListaMovimientosDTO consultarUltimosMovimientos(UltimosMovimientosRequest request)
			throws ConsultasApiException {
		return transaccionesConsultasService.consultarUltimosMovimientos(request);
	}
}