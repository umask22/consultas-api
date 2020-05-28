package com.prismamp.consultas.api.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDTO {
	
	@JsonAlias({"company_id","id"})
	@JsonProperty("company_id")
	private String companyId;
	
	@JsonAlias({"company_name","name"})
	@JsonProperty("company_name")
	private String companyName;
	
	@JsonAlias({"company_type","type"})
	@JsonProperty("company_type")
	private String companyType;
	
	@JsonAlias({"company_cuit","cuit"})
	@JsonProperty("company_cuit")
	private String companyCuit;
	
	@JsonProperty("category_id")
	private String categoryId;
	
	@JsonProperty("category_name")
	private String categoryName;
	
	@JsonProperty("category_type")
	private String categoryType;
	
	@JsonAlias({"title_identification","customer_id_title"})
	@JsonProperty("title_identification")
	private String titleIdentification;

	@JsonAlias({"allows_double_billing","allows_double_billing"})
	@JsonProperty("allows_double_billing")
	private boolean allowsDoubleBilling;
	
	@JsonAlias({"allows_usd","allows_usd"})
	@JsonProperty("allows_usd")
	private boolean allowsUsd;
	
	@JsonAlias({"allows_vdc_payments","allows_payment_vdc"})
	@JsonProperty("allows_vdc_payments")
	private boolean allowsVdcPayments;
	
	@JsonAlias({"allows_mdc_payments","allows_payment_mdc"})
	@JsonProperty("allows_mdc_payments")
	private boolean allowsMdcPayments;
	
	@JsonAlias({"allows_vcc_payments","allows_payment_vcc"})
	@JsonProperty("allows_vcc_payments")
	private boolean allowsVccPayments;
	
	@JsonAlias({"allows_mcc_payments","allows_payment_mcc"})
	@JsonProperty("allows_mcc_payments")
	private boolean allowsMccPayments;
	
	@JsonAlias({"allows_acc_payments","allows_payment_acc"})
	@JsonProperty("allows_acc_payments")
	private boolean allowsAccPayments;
	
	@JsonAlias({"minimum_cc_amount","amount_minimum"})
	@JsonProperty("minimum_cc_amount")
	private double minimumCcAmount;
	
	@JsonAlias({"maximum_cc_amount","amount_maximum"})
	@JsonProperty("maximum_cc_amount")
	private double maximumCcAmount;
	
	@JsonAlias({"payment_type","payment_type"})
	@JsonProperty("payment_type")
	private String paymentType;
	
	@JsonAlias({"allowed_amount","allowed_amount"})
	@JsonProperty("allowed_amount")
	private String allowedAmount;
	
	@JsonAlias({"only_queries","read_only"})
	@JsonProperty("only_queries")
	private boolean onlyQueries;
	
	@JsonAlias({"client_help_text","help_text"})
	@JsonProperty("client_help_text")
	private String clientHelpText = "";
}
