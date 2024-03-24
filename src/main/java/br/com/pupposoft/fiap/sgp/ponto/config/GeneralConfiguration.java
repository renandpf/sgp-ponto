package br.com.pupposoft.fiap.sgp.ponto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class GeneralConfiguration {

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		return new JavaMailSenderImpl();
	}
	
}
