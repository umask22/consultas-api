package com.prismamp.consultas.api.rest.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

	private String bank_id;
	private String document_type;
	private String document_number;
	private String channel;
	private String ip_address;
	private String terminal;
	private String origin;
	private String timestamp;
}
