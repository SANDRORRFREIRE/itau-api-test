package com.itau.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.itau.AppStarWarsServerApplication;
import com.itau.response.EstatisticasResponse;
import com.itau.util.StarWarsException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AppStarWarsServerApplication.class  })
public class EstatisticasServiceTest {

	@Autowired
	private EstatisticaService estatisticaService;

	@Test
	public void testGetEstatistica() throws StarWarsException {
 
	 	EstatisticasResponse result = estatisticaService.getEstatistica( new SimpleDateFormat("ddMMyyyy").format(new Date(System.currentTimeMillis())));
		assertFalse(result.getEstatistica().isEmpty());
	}
	
	@Test
	@Transactional
	public void testSaveEstatistica() {
        boolean valid;
		try {
			estatisticaService.saveEstatistica("PERSONAGENS", "Luke Skywalker");
			valid=true;
		} catch (StarWarsException e) {
			valid=false;
		}
		assertTrue(valid);
	}
}
