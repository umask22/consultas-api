package com.prismamp.consultas.api.rest.response;

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
public class CategoryResponse {
	@JsonAlias({"id", "idRubro"})
	@JsonProperty("id")
	private String id;
	
	@JsonAlias({"type", "tipo"})
	@JsonProperty("type")
	private String type;
	
	@JsonAlias({"name", "nombre"})
	@JsonProperty("name")
	private String name;
	
	@JsonAlias({"order", "orden"})
	@JsonProperty("order")
	private Integer order;
}
