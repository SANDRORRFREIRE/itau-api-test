package com.itau.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ConsultaResponse {
	
	@ApiModelProperty(value = "Dados do personagem do filme")
	@JsonProperty("personagem")
	private PersonagemResponse personagem;
	
	@ApiModelProperty(value = "Filmes que o personagem aparece")
	@JsonProperty("filmes")
	private List<FilmesResponse> filmes;
	
	@ApiModelProperty(value = "Sugestão de outros personagens que tem interação ao personagem consultado")
	@JsonProperty("sugestao_de_personagens")
	private List<PersonagemResponse> personagens;
	
	@ApiModelProperty(value = "Mensagens erros de consulta")
	@JsonProperty("mensagem")
	private String message;
	
	public PersonagemResponse getPersonagem() {
		return personagem;
	}

	public void setPersonagem(PersonagemResponse personagem) {
		this.personagem = personagem;
	}

	public List<FilmesResponse> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<FilmesResponse> filmes) {
		this.filmes = filmes;
	}

	public List<PersonagemResponse> getPersonagens() {
		return personagens;
	}

	public void setPersonagens(List<PersonagemResponse> personagens) {
		this.personagens = personagens;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	 
}
