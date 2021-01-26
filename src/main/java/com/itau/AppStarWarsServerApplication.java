package com.itau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * POC - Desenvolvido por Sandro Ricardo Rodrigues Freire
 * Avaliação processo seletivo Itau
 * Data 13/01/2021
 */
 
@SpringBootApplication
@ComponentScan({"com.itau"})
public class AppStarWarsServerApplication 
{
	public static void main(String[] args) {
		SpringApplication.run(AppStarWarsServerApplication.class, args);
	}
}
