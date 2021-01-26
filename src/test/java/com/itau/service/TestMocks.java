package com.itau.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.itau.client.model.FilmesClientModel;
import com.itau.client.model.PersonagemClientModel;

public class TestMocks {

	public static PersonagemClientModel getMockPersonagem()
			throws JsonParseException, JsonMappingException, IOException {
		StringBuilder str = new StringBuilder("");
		str.append("{");
		str.append("    \"name\": \"Luke Skywalker\",");
		str.append("    \"height\": \"172\",");
		str.append("    \"mass\": \"77\",");
		str.append("    \"hair_color\": \"blond\",");
		str.append("    \"skin_color\": \"fair\",");
		str.append("    \"eye_color\": \"blue\",");
		str.append("    \"birth_year\": \"19BBY\",");
		str.append("    \"gender\": \"male\",");
		str.append("    \"homeworld\": \"http://swapi.dev/api/planets/1/\",");
		str.append("    \"films\": [");
		str.append("        \"http://swapi.dev/api/films/1/\",");
		str.append("        \"http://swapi.dev/api/films/2/\",");
		str.append("        \"http://swapi.dev/api/films/3/\",");
		str.append("        \"http://swapi.dev/api/films/6/\"");
		str.append("    ],");
		str.append("    \"species\": [],");
		str.append("    \"vehicles\": [");
		str.append("        \"http://swapi.dev/api/vehicles/14/\",");
		str.append("        \"http://swapi.dev/api/vehicles/30/\"");
		str.append("    ],");
		str.append("    \"starships\": [");
		str.append("        \"http://swapi.dev/api/starships/12/\",");
		str.append("        \"http://swapi.dev/api/starships/22/\"");
		str.append("    ],");
		str.append("    \"created\": \"2014-12-09T13:50:51.644000Z\",");
		str.append("    \"edited\": \"2014-12-20T21:17:56.891000Z\",");
		str.append("    \"url\": \"http://swapi.dev/api/people/1/\"");
		str.append("}");
		return SwApiClient().readValue(str.toString(), PersonagemClientModel.class);
	}

	public static FilmesClientModel getFilmesMock() throws JsonParseException, JsonMappingException, IOException {
		StringBuilder str = new StringBuilder("");
		str.append("{");
		str.append("    \"title\": \"A New Hope\",");
		str.append("    \"episode_id\": 4,");
		str.append("    \"opening_crawl\": \"It is a test\",");
		str.append("    \"director\": \"George Lucas\",");
		str.append("    \"producer\": \"Gary Kurtz, Rick McCallum\",");
		str.append("    \"release_date\": \"1977-05-25\",");
		str.append("    \"characters\": [");
		str.append("        \"http://swapi.dev/api/people/1/\", ");
		str.append("        \"http://swapi.dev/api/people/2/\", ");
		str.append("        \"http://swapi.dev/api/people/3/\", ");
		str.append("        \"http://swapi.dev/api/people/4/\", ");
		str.append("        \"http://swapi.dev/api/people/5/\" ");
		str.append("    ],");
		str.append("    \"planets\": [");
		str.append("        \"http://swapi.dev/api/planets/1/\" ");
		str.append("    ],");
		str.append("    \"starships\": [");
		str.append("        \"http://swapi.dev/api/starships/2/\" ");
		str.append("    ],");
		str.append("    \"vehicles\": [");
		str.append("        \"http://swapi.dev/api/vehicles/4/\" ");
		str.append("    ],");
		str.append("    \"species\": [");
		str.append("        \"http://swapi.dev/api/species/1/\" ");
		str.append("    ],");
		str.append("    \"created\": \"2014-12-10T14:23:31.880000Z\",");
		str.append("    \"edited\": \"2014-12-20T19:49:45.256000Z\",");
		str.append("    \"url\": \"http://swapi.dev/api/films/1/\"");
		str.append("}");
		return SwApiClient().readValue(str.toString(), FilmesClientModel.class);
	}

	public static ObjectMapper SwApiClient() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return mapper;
	}
}
