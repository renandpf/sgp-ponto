package br.com.pupposoft.fiap.sgp.ponto.gateway.notificar;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import br.com.pupposoft.fiap.sgp.ponto.domain.Usuario;
import br.com.pupposoft.fiap.sgp.ponto.exception.NotificarException;
import br.com.pupposoft.fiap.sgp.ponto.gateway.NotificarGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class NotificarEmailGateway implements NotificarGateway {

	//private final JavaMailSender mailSender;

	@Override
	public void enviar(Usuario usuario, byte[] documentoEspelho) {
		try {


			/*MimeMessagePreparator preparator = mimeMessage -> {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				helper.setTo(usuario.getEmail());
				helper.setSubject("Espelho do ponto");

				// Adicionando o anexo
				//helper.addAttachment("Espelho do ponto", documentoEspelho);

				// Corpo do e-mail (opcional)
				helper.setText("Este é um e-mail com anexo.");
			};*/


		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new NotificarException();
		}
	}
}
