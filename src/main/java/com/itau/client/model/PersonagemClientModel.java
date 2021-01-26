package com.itau.client.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonagemClientModel {

	@JsonProperty("name")
	private String nome;
	@JsonProperty("height")
	private String altura;
	@JsonProperty("mass")
	private String peso;
	@JsonProperty("hair_color")	
	private String corcabelo; 
	@JsonProperty("skin_color")
	private String corpele;
	@JsonProperty("eye_color")
	private String corolhos;
	@JsonProperty("birth_year")
	private String datanascimento;
	@JsonProperty("gender")
	private String genero;
	@JsonProperty("homeworld")
	private String planetanatal;
	@JsonProperty("films")
	private List<String> filmes;
	@JsonProperty("species")
	private List<String> especies;
	@JsonProperty("vehicles")
	private List<String> veiculos;
	@JsonProperty("starships")
	private List<String> naves;
	@JsonProperty("created")
	private String datacriacao;
	@JsonProperty("edited")
	private String dataedicao;
	@JsonProperty("url")
	private String url;
	@JsonProperty("detail")
	private String detail;
	
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

	public List<String> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<String> filmes) {
		this.filmes = filmes;
	}

	public List<String> getEspecies() {
		return especies;
	}

	public void setEspecies(List<String> especies) {
		this.especies = especies;
	}

	public List<String> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<String> veiculos) {
		this.veiculos = veiculos;
	}

	public List<String> getNaves() {
		return naves;
	}

	public void setNaves(List<String> naves) {
		this.naves = naves;
	}

	public String getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(String datacriacao) {
		this.datacriacao = datacriacao;
	}

	public String getDataedicao() {
		return dataedicao;
	}

	public void setDataedicao(String dataedicao) {
		this.dataedicao = dataedicao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCorcabelo() {
		return corcabelo;
	}

	public void setCorcabelo(String corcabelo) {
		this.corcabelo = corcabelo;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
