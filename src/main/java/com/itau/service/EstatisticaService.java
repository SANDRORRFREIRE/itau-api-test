package com.itau.service;

import com.itau.response.EstatisticasResponse;
import com.itau.util.StarWarsException;

public interface EstatisticaService {
 
	EstatisticasResponse getEstatistica(String dataConsulta) throws StarWarsException;

	void saveEstatistica(String tipoConsulta, String termo) throws StarWarsException;

}
