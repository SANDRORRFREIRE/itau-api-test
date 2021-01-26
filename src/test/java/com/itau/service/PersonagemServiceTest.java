package com.itau.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.itau.AppStarWarsServerApplication;
import com.itau.client.SwApiClient;
import com.itau.response.ConsultaResponse;
import com.itau.service.impl.PersonagemServiceImpl;
import com.itau.util.StarWarsException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AppStarWarsServerApplication.class })
public class PersonagemServiceTest {

	@Mock
	private SwApiClient swApiClient;
	
	@InjectMocks
	private PersonagemService personagemService=new PersonagemServiceImpl();
	
    @Before
    public void setUp() throws Exception {

         MockitoAnnotations.initMocks(this);
    }
    
	@Test
	public void personagemTest() throws JsonParseException, JsonMappingException, StarWarsException, IOException {	
 
		when(swApiClient.getPersonagem(any())).thenReturn(TestMocks.getMockPersonagem());
		when(swApiClient.getFilmes(any())).thenReturn(TestMocks.getFilmesMock());
 		
		ConsultaResponse response = personagemService.personagem(1L);
		
		Assert.assertTrue(!response.getFilmes().isEmpty() && response.getPersonagem() != null && !response.getPersonagens().isEmpty());
		
	}
	
	 
	
}
