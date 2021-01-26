package com.itau.client.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmesClientModel {
	
	@JsonProperty("title")
	private String titulo;
	@JsonProperty("episode_id")
	private Long episodio;
	@JsonProperty("opening_crawl")
	private String informacoes;
	@JsonProperty("director")
	private String diretor;
	@JsonProperty("producer")
	private String produtor;
	@JsonProperty("release_date")
	private String dataestreia;
	@JsonProperty("characters")
	private List<String> personagens;
	@JsonProperty("planets")
	private List<String> planetas;
	@JsonProperty("starships")
	private List<String> naves;
	@JsonProperty("vehicles")
	private List<String> veiculos;
	@JsonProperty("species")
	private List<String> especies;
	@JsonProperty("created")
	private String criadoem;
	@JsonProperty("edited")
	private String editadoem;
	@JsonProperty("url")
	private String url;
	@JsonProperty("detail")
	private String detail;
	
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

	public List<String> getPersonagens() {
		return personagens;
	}

	public void setPersonagens(List<String> personagens) {
		this.personagens = personagens;
	}

	public List<String> getPlanetas() {
		return planetas;
	}

	public void setPlanetas(List<String> planetas) {
		this.planetas = planetas;
	}

	public List<String> getNaves() {
		return naves;
	}

	public void setNaves(List<String> naves) {
		this.naves = naves;
	}

	public List<String> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<String> veiculos) {
		this.veiculos = veiculos;
	}

	public List<String> getEspecies() {
		return especies;
	}

	public void setEspecies(List<String> especies) {
		this.especies = especies;
	}

	public String getCriadoem() {
		return criadoem;
	}

	public void setCriadoem(String criadoem) {
		this.criadoem = criadoem;
	}

	public String getEditadoem() {
		return editadoem;
	}

	public void setEditadoem(String editadoem) {
		this.editadoem = editadoem;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
