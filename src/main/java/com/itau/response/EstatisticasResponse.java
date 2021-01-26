package com.itau.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class EstatisticasResponse {
	
	@ApiModelProperty("Dados da Estatistica")
	@JsonProperty("estatistica")
	private List<EstatisticaResponse> estatistica;
 
	@ApiModelProperty("Total de Consultas")
	@JsonProperty("total_consultas")
	private Long total;
	
	@ApiModelProperty(value = "Mensagem")
	@JsonProperty("mensagem")
    private String message;
	

	public String getMessage() {
		return message;
	}

	public EstatisticasResponse setEstatistica(List<EstatisticaResponse> estatistica, long total) {
		this.estatistica = estatistica;
		this.total=total;
		return this;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<EstatisticaResponse> getEstatistica() {
		return estatistica;
	}

	public void setEstatistica(List<EstatisticaResponse> estatistica) {
		this.estatistica = estatistica;
	}
	
	
}
