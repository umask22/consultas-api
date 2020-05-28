package com.prismamp.consultas.api.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaCodDeBarraDTO {
	
	@JsonAlias({"invoice_id","idFactura"})
	@JsonProperty("invoice_id")
	private String invoiceId;
	
	@JsonAlias({"customer_id","idCliente"})
	@JsonProperty("customer_id")
	private String customerId;
	
	@JsonAlias({"amount","importe"})
	@JsonProperty("amount")
	private double amount;
	
	@JsonAlias({"currency","moneda"})
	@JsonProperty("currency")
	private String currency;
	
	@JsonAlias({"due_date","vencimiento"})
	@JsonProperty("due_date")
	private Date dueDate;
	
	@JsonAlias({"screen_description","descPantalla"})
	@JsonProperty("screen_description")
	private String screenDescription = "";
	
	@JsonAlias({"customer_description","descripcionUsuario"})
	@JsonProperty("customer_description")
	private String customerDescription;
	
	@JsonAlias({"additional_data","additional_data"})
	@JsonProperty("additional_data")
	private String additionalData = "";
	
	@JsonAlias({"recurrent_payment","pagoRecurrente"})
	@JsonProperty("recurrent_payment")
	private boolean recurrent_payment;
	
	@JsonAlias({"annual","anual"})
	@JsonProperty("annual")
	private boolean annual;
	
	@JsonAlias({"create_mode","modoAlta"})
	@JsonProperty("create_mode")
	private String create_mode;
}
