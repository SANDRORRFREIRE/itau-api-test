package com.itau.builder;

import com.itau.response.FilmesResponse;

public class FilmesBuilder {

	private String titulo;

	private Long episodio;

	private String informacoes;

	private String diretor;

	private String produtor;

	private String dataestreia;

	public FilmesResponse build() {
		FilmesResponse filmesReponse = new FilmesResponse();
		filmesReponse.setTitulo(titulo);
		filmesReponse.setEpisodio(episodio);
		filmesReponse.setInformacoes(informacoes);
		filmesReponse.setDiretor(diretor);
		filmesReponse.setProdutor(produtor);
		filmesReponse.setTitulo(titulo);
		filmesReponse.setDataestreia(dataestreia);
		return filmesReponse;
	}

	public FilmesBuilder titulo(String titulo) {
		this.titulo = titulo;
		return this;
	}

	public FilmesBuilder episodio(Long episodio) {
		this.episodio = episodio;
		return this;
	}

	public FilmesBuilder informacoes(String informacoes) {
		this.informacoes = informacoes;
		return this;
	}

	public FilmesBuilder diretor(String diretor) {
		this.diretor = diretor;
		return this;
	}

	public FilmesBuilder produtor(String produtor) {
		this.produtor = produtor;
		return this;
	}

	public FilmesBuilder dataestreia(String dataestreia) {
		this.dataestreia = dataestreia;
		return this;
	}

}
