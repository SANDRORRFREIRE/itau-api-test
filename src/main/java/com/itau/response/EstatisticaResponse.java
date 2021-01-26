package com.itau.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class EstatisticaResponse {
	
	@ApiModelProperty(value = "Quantidades de consultas efetuadas")
	@JsonProperty("quantidade_consultas")
	private Long quantidade;
	
	@ApiModelProperty(value = "Tipos de consultas")
	@JsonProperty("tipo_consulta")
	private String consulta;
	
 	
	@ApiModelProperty(value = "Termos Consultados")
	@JsonProperty("termo")
	private String termo;
 	
 	    
	public Long getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}


	public String getConsulta() {
		return consulta;
	}


	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

 
	public String getTermo() {
		return termo;
	}


	public void setTermo(String termo) {
		this.termo = termo;
	}

 
	
}
