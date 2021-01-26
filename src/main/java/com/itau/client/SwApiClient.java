package com.itau.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.itau.client.model.FilmesClientModel;
import com.itau.client.model.PersonagemClientModel;
import com.itau.config.Messages;
import com.itau.util.StarWarsException;

@Configuration
public class SwApiClient {

	private final CloseableHttpClient httpClient = HttpClients.createDefault();
	 
	private ObjectMapper mapper = new ObjectMapper();

	private final Logger logger = LoggerFactory.getLogger(SwApiClient.class);

 	public SwApiClient() {
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
 	}

	private String sendGet(String url) throws Exception {

		String jSonRet=null;
		HttpGet request = new HttpGet(url);

		try (CloseableHttpResponse response = httpClient.execute(request)) {

 			response.getStatusLine().toString();

			HttpEntity entity = response.getEntity();
 
			if (entity != null) {
 
				jSonRet=EntityUtils.toString(entity);

			}

			return jSonRet;

		}

	}
 
	public PersonagemClientModel getPersonagem(String url) throws StarWarsException {
		PersonagemClientModel personagemClientResponse;
		try {
			personagemClientResponse = mapper.readValue(sendGet(url), PersonagemClientModel.class);
		} catch (JsonParseException e) {
			logger.error(Messages.ERROR_API, e);
			throw new StarWarsException(Messages.ERROR_JSON_PARSER, Messages.SERVER_OTHER_ERROR);
		} catch (JsonMappingException e) {
			logger.error(Messages.ERROR_API, e);
			throw new StarWarsException(Messages.ERROR_JSON_MAPPING, Messages.SERVER_OTHER_ERROR);
		} catch (IOException e) {
			logger.error(Messages.ERROR_API, e);
			throw new StarWarsException(Messages.ERROR_IO, Messages.SERVER_OTHER_ERROR);
		} catch (Exception e) {
			logger.error(Messages.ERROR_API, e);
			throw new StarWarsException(Messages.ERROR_GENERIC, Messages.SERVER_OTHER_ERROR);
		}
		if( personagemClientResponse.getDetail() != null && personagemClientResponse.getDetail().equalsIgnoreCase("Not found")  ) 
			throw new StarWarsException(Messages.ERROR_NOTFOUND, Messages.SERVER_OTHER_ERROR);
		
		return personagemClientResponse;
	}

	public FilmesClientModel getFilmes(String url) throws StarWarsException {
		FilmesClientModel filmesClientResponse;
		try {
			filmesClientResponse = mapper.readValue(sendGet(url), FilmesClientModel.class);
		} catch (JsonParseException e) {
			logger.error(Messages.ERROR_API, e);
			throw new StarWarsException(Messages.ERROR_JSON_PARSER, Messages.SERVER_OTHER_ERROR);
		} catch (JsonMappingException e) {
			logger.error(Messages.ERROR_API, e);
			throw new StarWarsException(Messages.ERROR_JSON_MAPPING, Messages.SERVER_OTHER_ERROR);
		} catch (IOException e) {
			logger.error(Messages.ERROR_API, e);
			throw new StarWarsException(Messages.ERROR_IO, Messages.SERVER_OTHER_ERROR);
		} catch (Exception e) {
			logger.error(Messages.ERROR_API, e);
			throw new StarWarsException(Messages.ERROR_GENERIC, Messages.SERVER_OTHER_ERROR);
		}
		if( filmesClientResponse.getDetail() != null && filmesClientResponse.getDetail().equalsIgnoreCase("Not found")  ) 
			throw new StarWarsException(Messages.ERROR_NOTFOUND, Messages.SERVER_OTHER_ERROR);
		
		return filmesClientResponse;
	}

}
