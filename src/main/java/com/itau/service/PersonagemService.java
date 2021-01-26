package com.itau.service;

import com.itau.response.ConsultaResponse;
import com.itau.util.StarWarsException;

public interface PersonagemService {

	ConsultaResponse personagem(Long person) throws StarWarsException;
  
}
