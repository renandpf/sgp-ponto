package br.com.pupposoft.fiap.sgp.ponto.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class GeneralConfiguration {

	@Value("${spring.mail.host}")
	private String springMailHost;

	@Value("${spring.mail.port}")
	private Integer springMailPort;
	
	@Value("${spring.mail.username}")
	private String springMailUsername;
	
	@Value("${spring.mail.password}")
	private String springMailPassword;
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost(springMailHost);
	    mailSender.setPort(springMailPort);
	    
	    mailSender.setUsername(springMailUsername);
	    mailSender.setPassword(springMailPassword);
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
		
		return mailSender;
	}
	
}
