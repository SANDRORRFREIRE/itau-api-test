package com.itau.builder;

import com.itau.response.PersonagemResponse;

public class PersonagemBuilder {
	 
	private String nome;
 
	private String altura;
	 
	private String peso;
	 
	private String corcabelo;
	
	private String corpele;
 
	private String corolhos;
	 
	private String datanascimento;
 
	private String genero;
	 
	private String planetanatal;
	
	public PersonagemResponse build() {
		PersonagemResponse personagemResponse=new PersonagemResponse();
		personagemResponse.setAltura(altura);
		personagemResponse.setCorolhos(corolhos);
		personagemResponse.setCorpele(corpele);
		personagemResponse.setDatanascimento(datanascimento);
		personagemResponse.setGenero(genero);
		personagemResponse.setNome(nome);
		personagemResponse.setPeso(peso);
		personagemResponse.setPlanetanatal(planetanatal);
		personagemResponse.setCorcabelo(corcabelo);
		return personagemResponse;
	}
	
	public PersonagemBuilder corcabelo(String corcabelo) {
		this.corcabelo=corcabelo;
		return this;
	}
	public PersonagemBuilder nome(String nome) {
		this.nome=nome;
		return this;
	}
	public PersonagemBuilder altura(String altura) {
		this.altura=altura;
		return this;
	}
	public PersonagemBuilder peso(String peso) {
		this.peso=peso;
		return this;
	}
	public PersonagemBuilder corpele(String corpele) {
		this.corpele=corpele;
		return this;
	}
	public PersonagemBuilder corolhos(String corolhos) {
		this.corolhos=corolhos;
		return this;
	}
	public PersonagemBuilder datanascimento(String datanascimento) {
		this.datanascimento=datanascimento;
		return this;
	}
	public PersonagemBuilder genero(String genero) {
		this.genero=genero;
		return this;
	}
	public PersonagemBuilder planetanatal(String planetanatal) {
		this.planetanatal=planetanatal;
		return this;
	}
}
