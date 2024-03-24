package br.com.pupposoft.fiap.sgp.ponto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class GeneralConfiguration {

	@Bean
	public JavaMailSender getJavaMailSender() {
		return new JavaMailSenderImpl();
	}
	
}
