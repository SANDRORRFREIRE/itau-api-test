package com.itau.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Messages {

	public static String ERRO_VALIDACAO_DOCUMENTO;
	public static String SERVER_DATABASE_ERROR;
	public static String SERVER_OTHER_ERROR;
	public static String ERROR_API;
	public static String ERROR_MSG_NOTFOUND;
 
	public static final int ERROR_JSON_PARSER = 801;
	public static final int ERROR_JSON_MAPPING = 802;
	public static final int ERROR_IO = 803;
	public static final int ERROR_GENERIC = 803;
	public static final int ERROR_NOTFOUND = 805;
	public static final int ERROR_DATE_VALIDATOR = 806;
	

	@Value("${starwars.message.validacao.documento}")
	public void setErroValidacao(String value) {
		ERRO_VALIDACAO_DOCUMENTO = value;
	}

	@Value("${starwars.message.server.database_error}")
	public void seServerDataBaseError(String value) {
		SERVER_DATABASE_ERROR = value;
	}

	@Value("${starwars.message.server.other_error}")
	public void setServerOtherError(String value) {
		SERVER_OTHER_ERROR = value;
	}

	@Value("${starwars.message.server.error_api}")
	public void setErrorApi(String value) {
		ERROR_API = value;
	}

	@Value("${starwars.message.server.error_msg}")
	public void setMsgNotFound(String value) {
		ERROR_MSG_NOTFOUND = value;
	}
	
 
}
