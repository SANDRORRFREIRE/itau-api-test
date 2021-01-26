package com.itau.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.entity.EstatisticaEntity;
import com.itau.repository.EstatisticaCustomRepository;
import com.itau.repository.EstatisticaRepository;
import com.itau.repository.model.EstatisticaModel;
import com.itau.response.EstatisticaResponse;
import com.itau.response.EstatisticasResponse;
import com.itau.service.EstatisticaService;
import com.itau.util.DataValidate;
import com.itau.util.StarWarsException;

@Service
public class EstatisticaServiceImpl implements EstatisticaService {

	@Autowired
	private EstatisticaRepository estatisticaRepository;

	@Autowired
	private EstatisticaCustomRepository estatisticaCustomRepository;
 
	@Override
	@Transactional
	public void saveEstatistica(String tipoConsulta, String termo) throws StarWarsException {

		EstatisticaEntity estatisticaEntity = new EstatisticaEntity();

		estatisticaEntity.setConsulta(tipoConsulta);
		estatisticaEntity.setSttermo(termo);
 
		estatisticaEntity.setDtconsulta(new Date(System.currentTimeMillis()));

		estatisticaRepository.save(estatisticaEntity);

	}

	@Override
	public EstatisticasResponse getEstatistica(String dataConsulta) throws StarWarsException {

		Date dataDeConsulta = DataValidate.getAndValidDate(dataConsulta);

		List<EstatisticaResponse> estatisticasResponse = new ArrayList<>();
		for (EstatisticaModel estatisticaModel : estatisticaCustomRepository.getReportEstatistica(dataDeConsulta)) {
			estatisticasResponse.add(getEstatisticaResponse(estatisticaModel.getTipo(), estatisticaModel.getTermo(),
					estatisticaModel.getQuantidade()));
		}

		return new EstatisticasResponse().setEstatistica(estatisticasResponse, estatisticasResponse.size());
	}

	private EstatisticaResponse getEstatisticaResponse(String tipo, String termo, Long value) {
		EstatisticaResponse response = new EstatisticaResponse();
		response.setConsulta(tipo);
		response.setTermo(termo);
		response.setQuantidade(value);
		return response;
	}
}
