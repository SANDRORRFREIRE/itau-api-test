package com.itau.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.config.Messages;
import com.itau.response.ConsultaResponse;
import com.itau.response.EstatisticasResponse;
import com.itau.service.EstatisticaService;
import com.itau.service.PersonagemService;
import com.itau.util.StarWarsException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "starwars-api")
@RestController
@RequestMapping("/starwars")
public class StarWarsController {

	private final Logger logger = LoggerFactory.getLogger(StarWarsController.class);

	@Autowired
	private PersonagemService personagemService;

	@Autowired
	private EstatisticaService estatisticaService;
    
	private static final String TIPO_CONSULTA="PERSONAGENS";
	
	@ApiOperation(value = "Gera relatórios de Filmes de Star Wars")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Relatório foi gerado com sucesso"),
			@ApiResponse(code = 400, message = "Erro critico"),
			@ApiResponse(code = 404, message = "Registro não localizado"),
			@ApiResponse(code = 500, message = "Nosso servidor retornou um erro inesperado"), })
	@GetMapping(value = "/personagem/{personagem}")
	public ResponseEntity<ConsultaResponse> reportPersonagem(@PathVariable("personagem") Long personagem) {

		ConsultaResponse response;
		try {
			response = personagemService.personagem(personagem);
			estatisticaService.saveEstatistica(TIPO_CONSULTA, response.getPersonagem().getNome());
		} catch (StarWarsException e) {
			if (e.getCode().equals(Messages.ERROR_NOTFOUND))
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage(Messages.ERROR_MSG_NOTFOUND));

			logger.error(Messages.SERVER_OTHER_ERROR, e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage(Messages.SERVER_OTHER_ERROR));
		} catch (Exception e) {
			logger.error(Messages.SERVER_OTHER_ERROR, e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage(Messages.SERVER_OTHER_ERROR));
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@ApiOperation(value = "Retorna a estatistica das consultas efetuadas ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Consulta com sucesso"),
			@ApiResponse(code = 400, message = "Erro critico"),
			@ApiResponse(code = 404, message = "Relatório inexistente"),
			@ApiResponse(code = 406, message = "Data de consulta inválida"),
			@ApiResponse(code = 500, message = "Nosso servidor retornou um erro inesperado"), })
	@GetMapping(value = "/estatistica/{dataConsulta}")
	public ResponseEntity<EstatisticasResponse> reportEstatistica(@PathVariable("dataConsulta") String dataConsulta) {
		EstatisticasResponse estatisticasResponse;
		try {
			estatisticasResponse = estatisticaService.getEstatistica(dataConsulta);
		} catch (StarWarsException e) {
			if (e.getCode().equals(Messages.ERROR_NOTFOUND)) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessageSt(Messages.ERROR_MSG_NOTFOUND));
			} else if (e.getCode().equals(Messages.ERROR_DATE_VALIDATOR)) {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
						.body(errorMessageSt(Messages.ERROR_MSG_NOTFOUND));
			}
			logger.error(Messages.SERVER_OTHER_ERROR, e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessageSt(Messages.SERVER_OTHER_ERROR));
		} catch (Exception e) {
			logger.error(Messages.SERVER_OTHER_ERROR, e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessageSt(Messages.SERVER_OTHER_ERROR));
		}

		return ResponseEntity.status(HttpStatus.OK).body(estatisticasResponse);

	}

	private EstatisticasResponse errorMessageSt(String message) {
		EstatisticasResponse errorMessage = new EstatisticasResponse();
		errorMessage.setMessage(message);
		return errorMessage;
	}

	private ConsultaResponse errorMessage(String message) {
		ConsultaResponse errorMessage = new ConsultaResponse();
		errorMessage.setMessage(message);
		return errorMessage;
	}
}
