package com.itau.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwApiConfiguration {

	private static final String PATHHTTP = "http://";
	private static final String PATHHTTPS = "https://";
    
	public static String URL_SWAPI;
	
	@Value("${client.sw.api.url}")
	public void setUrl(String url) {
		URL_SWAPI=url;
	}
    
	public static String getUrlHttps(String value) {
		return value.replace(PATHHTTP, PATHHTTPS);
	}
}