package com.itau.util;

public class StarWarsException extends Exception {

	// classe apenas para tratar mensagens
	// utilzando um DE PARA de Erro

	/**
	 * 
	 */
	private static final long serialVersionUID = 3988359893038341746L;
	private final Integer code;
	private final String message;

	public StarWarsException(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	
	public Integer getCode() {
		return code;
	}
	
    @Override
	public String getMessage() {
		return message;
	}

}
