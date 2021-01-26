package com.itau.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonagemResponse {
	
	@ApiModelProperty(value = "Nome do personagem")
	@JsonProperty("nome")
	private String nome;
	
	@ApiModelProperty(value = "Altura do personagem")
	@JsonProperty("altura")
	private String altura;
	
	@ApiModelProperty(value = "Peso do personagem")
	@JsonProperty("peso")
	private String peso;
	
	@ApiModelProperty(value = "Cor de cabelo do personagem")
	@JsonProperty("cor_cabelo")
	private String corcabelo;
	
	@ApiModelProperty(value = "Cor da pele do personagem")
	@JsonProperty("cor_pele")
	private String corpele;
	
	@ApiModelProperty(value = "Cor dos olhos do personagem")
	@JsonProperty("cor_olhos")
	private String corolhos;
	
	@ApiModelProperty(value = "Data de nascimento do personagem")
	@JsonProperty("data_nascimento")
	private String datanascimento;
	
	@ApiModelProperty(value = "Genero do personagem")
	@JsonProperty("genero")
	private String genero;
	
	@ApiModelProperty(value = "Planeta natal do personagem")
	@JsonProperty("planeta_natal")
	private String planetanatal;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getCorpele() {
		return corpele;
	}
	public void setCorpele(String corpele) {
		this.corpele = corpele;
	}
	public String getCorolhos() {
		return corolhos;
	}
	public void setCorolhos(String corolhos) {
		this.corolhos = corolhos;
	}
	public String getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getPlanetanatal() {
		return planetanatal;
	}
	public void setPlanetanatal(String planetanatal) {
		this.planetanatal = planetanatal;
	}
	public String getCorcabelo() {
		return corcabelo;
	}
	public void setCorcabelo(String corcabelo) {
		this.corcabelo = corcabelo;
	}
 
}
