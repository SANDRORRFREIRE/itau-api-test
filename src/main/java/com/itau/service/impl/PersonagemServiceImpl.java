package com.itau.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.builder.StarWarBuilder;
import com.itau.client.SwApiClient;
import com.itau.config.SwApiConfiguration;
import com.itau.response.ConsultaResponse;
import com.itau.response.PersonagemResponse;
import com.itau.service.PersonagemService;
import com.itau.util.StarWarsException;

@Service
public class PersonagemServiceImpl implements PersonagemService {

	public static final int SUGGESTIONS = 3;

	@Autowired
	private SwApiClient swApiClient;

	private List<String> suggestions;

	private ConsultaResponse consultaResponse;

	@Override
	public ConsultaResponse personagem(Long person) throws StarWarsException {

		String url = SwApiConfiguration.URL_SWAPI + "people/" + String.valueOf(person) + "/";

		consultaResponse = new ConsultaResponse();
		consultaResponse.setPersonagem(searchPersonagem(url, true));
		consultaResponse.setPersonagens(new ArrayList<>());
		for (int i = 0; i < SUGGESTIONS; ++i) {
			consultaResponse.getPersonagens().add(searchPersonagem(suggestions.get(i), false));
		}
		return consultaResponse;
	}

	private PersonagemResponse searchPersonagem(String url, boolean sugest) throws StarWarsException {
		StarWarBuilder starWarBuilder = new StarWarBuilder(swApiClient);

		PersonagemResponse personagemResponse = starWarBuilder.getPersonagem(url);
		if (personagemResponse != null) {

			if (sugest) {

				consultaResponse.setFilmes(new ArrayList<>());

				for (String filme : starWarBuilder.getPersonagemClientResponse().getFilmes()) {
					consultaResponse.getFilmes().add(starWarBuilder.getFilmes(SwApiConfiguration.getUrlHttps(filme)));
				}

				suggestions = new ArrayList<>();

				if (!starWarBuilder.getFilmesClientResponse().getPersonagens().isEmpty()) {
					for (String sug : starWarBuilder.getFilmesClientResponse().getPersonagens()) {
						String urlCompare = SwApiConfiguration.getUrlHttps(sug);
						if (!urlCompare.equalsIgnoreCase(url))
							suggestions.add(urlCompare);
					}
				}
			}

		}
		return personagemResponse;

	}

}
