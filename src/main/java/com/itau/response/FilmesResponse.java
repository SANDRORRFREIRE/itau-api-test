package com.itau.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmesResponse {
	
	@ApiModelProperty(value = "Titulo do filme")
	@JsonProperty("titulo")
	private String titulo;
	
	@ApiModelProperty(value = "Id do Episódio")
	@JsonProperty("id_episodio")
	private Long episodio;
	
	@ApiModelProperty(value = "Informações do filme")
	@JsonProperty("informacoes")
	private String informacoes;
	
	@ApiModelProperty(value = "Nome do diretor")
	@JsonProperty("diretor")
	private String diretor;
	
	@ApiModelProperty(value = "Nome do produtor")
	@JsonProperty("produtor")
	private String produtor;
	
	@ApiModelProperty(value = "Data de estréia do filme")
	@JsonProperty("data_de_estreia")
	private String dataestreia;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Long getEpisodio() {
		return episodio;
	}
	public void setEpisodio(Long episodio) {
		this.episodio = episodio;
	}
	public String getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public String getProdutor() {
		return produtor;
	}
	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}
	public String getDataestreia() {
		return dataestreia;
	}
	public void setDataestreia(String dataestreia) {
		this.dataestreia = dataestreia;
	}
 
}
