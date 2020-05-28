package com.prismamp.consultas.api.model.mapper;

import org.springframework.stereotype.Component;

import com.prismamp.consultas.api.exception.ConsultasApiException;
import com.prismamp.consultas.api.model.dto.PagoInfoDTO;
import com.prismamp.consultas.api.model.dto.TarjetaPagoDTO;
import com.prismamp.consultas.api.model.dto.TicketPagoDTO;

@Component
public class UltimoPagoMapper extends Mapper<PagoInfoDTO, TicketPagoDTO>
{
	private static final String DEBITO = "9";
	private static final String CREDITO = "3";
	
	@Override
	public TicketPagoDTO convert(PagoInfoDTO pago) throws ConsultasApiException
	{
		TicketPagoDTO ticket = new TicketPagoDTO();
		ticket.setControlNum(pago.getNroControl());
		ticket.setDescDeuda(pago.getLeyenda());
		ticket.setFechaPago(pago.getFechaPago());
		ticket.setHostOnLine(pago.isHostOnLine());
		ticket.setIdAnticipo(pago.getIdAnticipo());
		ticket.setIdDeuda(pago.getIdCliente());
		ticket.setIdEmpresa(pago.getIdEmpresa());
		ticket.setLeyPago(pago.getLeyenda());
		ticket.setLeyAdhesion(pago.getDescripcion());
		ticket.setMoneda(pago.getMoneda());
		ticket.setMonto(pago.getImporte());
		ticket.setPeriodo(pago.getPeriodo());
		ticket.setPrePago(pago.isPrePago());
		ticket.setTransacNum(pago.getNroTransac().substring(6,10));
		ticket.setVencimiento(pago.getVencimiento());
		ticket.setDescripcion(pago.getDescripcion());
		
		if(CREDITO.equals(pago.getCuenta().getTipo()) || DEBITO.equals(pago.getCuenta().getTipo()))
		{
			TarjetaPagoDTO tarjeta = new TarjetaPagoDTO();
			tarjeta.setTipoTarjeta(pago.getCuenta().getNumero().substring(10,12));
			tarjeta.setNroTarjeta(pago.getCuenta().getNumero().substring(0,4));
			tarjeta.setCuotas(pago.getCuenta().getNumero().substring(12,14));
			ticket.setTarjeta(tarjeta);
		}
		else
		{
			ticket.setCuenta(pago.getCuenta());
		}
		
		return ticket;
	}
}
