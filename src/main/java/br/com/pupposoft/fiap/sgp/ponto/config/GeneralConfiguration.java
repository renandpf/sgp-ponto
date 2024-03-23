package br.com.pupposoft.fiap.sgp.ponto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class GeneralConfiguration {

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
	
}
