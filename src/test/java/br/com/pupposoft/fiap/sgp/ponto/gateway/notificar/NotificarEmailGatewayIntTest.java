package br.com.pupposoft.fiap.sgp.ponto.gateway.notificar;

import java.util.Properties;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import br.com.pupposoft.fiap.sgp.ponto.domain.Usuario;
import br.com.pupposoft.fiap.sgp.ponto.gateway.NotificarGateway;
import br.com.pupposoft.fiap.test.databuilder.DataBuilderBase;

@Disabled
class NotificarEmailGatewayIntTest {
	
	@Test
	void shouldSucessOnNotificar() {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
	    
	    mailSender.setUsername("XXX");
	    mailSender.setPassword("YYY");//No google, utilizar a "senha de app"
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
		
		
		NotificarGateway notificarGateway = new NotificarEmailGateway(mailSender);
		
		Usuario usuario = Usuario.builder()
				.email("yyy@mail.com")//Colocar o email destino aqui
				.build();
		
		notificarGateway.enviar(usuario, DataBuilderBase.getRandomString().getBytes());
	}

}
