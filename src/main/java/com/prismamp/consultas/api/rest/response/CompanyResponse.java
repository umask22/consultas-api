package com.prismamp.consultas.api.rest.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyResponse {
	
	private String id;
	private int order = 0;
	private String type;
	private String name;
	private String cuit;
	private String customer_id_title;
	private Integer subscription_type;
	private Integer payment_type;
	private String currency;
	private String additional_data;
	private boolean read_only;
	private boolean pmc_only;
	
	private boolean allows_usd;
	private boolean allows_ebpp;
	private Integer allowed_amount;
	private boolean allows_payment_recurrent;
	private boolean allows_double_billing;
	private boolean allows_payment_vdc;
	private boolean allows_payment_mdc;
	private boolean allows_payment_vcc;
	private boolean allows_payment_mcc;
	private boolean allows_payment_acc;
	
	private double amount_minimum;
	private double amount_maximum;
	
	private String help_text;
	private CategoryResponse category;
}
