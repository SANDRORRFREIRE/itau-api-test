package com.itau.builder;

import com.itau.client.SwApiClient;
import com.itau.client.model.FilmesClientModel;
import com.itau.client.model.PersonagemClientModel;
import com.itau.response.FilmesResponse;
import com.itau.response.PersonagemResponse;
import com.itau.util.StarWarsException;

public class StarWarBuilder {
 
 
	private SwApiClient swApiClient;
	private PersonagemClientModel personagemClientResponse;
	private FilmesClientModel filmesClientResponse;
 
	public StarWarBuilder(SwApiClient swApiClient) {
		this.swApiClient = swApiClient;
	}

	public PersonagemClientModel getPersonagemClientResponse() {
		return personagemClientResponse;
	}

	public void setPersonagemClientResponse(PersonagemClientModel personagemClientResponse) {
		this.personagemClientResponse = personagemClientResponse;
	}

	public FilmesClientModel getFilmesClientResponse() {
		return filmesClientResponse;
	}

	public void setFilmesClientResponse(FilmesClientModel filmesClientResponse) {
		this.filmesClientResponse = filmesClientResponse;
	}

	public PersonagemResponse getPersonagem(String url) throws StarWarsException {
		personagemClientResponse = swApiClient.getPersonagem(url);
		if (personagemClientResponse != null)
			return new PersonagemBuilder().altura(personagemClientResponse.getAltura())
					.corcabelo(personagemClientResponse.getCorcabelo())
					.corolhos(personagemClientResponse.getCorolhos()).corpele(personagemClientResponse.getCorpele())
					.datanascimento(personagemClientResponse.getDatanascimento())
					.genero(personagemClientResponse.getGenero()).nome(personagemClientResponse.getNome())
					.peso(personagemClientResponse.getPeso()).planetanatal(personagemClientResponse.getPlanetanatal())
					.build();

		return null;
	}

	public FilmesResponse getFilmes(String url) throws StarWarsException {
		filmesClientResponse = swApiClient.getFilmes(url);
		if (filmesClientResponse != null)
			return new FilmesBuilder().dataestreia(filmesClientResponse.getDataestreia())
					.diretor(filmesClientResponse.getDiretor()).episodio(filmesClientResponse.getEpisodio())
					.informacoes(filmesClientResponse.getInformacoes()).produtor(filmesClientResponse.getProdutor())
					.titulo(filmesClientResponse.getTitulo()).build();

		return null;
	}
	
 

}
