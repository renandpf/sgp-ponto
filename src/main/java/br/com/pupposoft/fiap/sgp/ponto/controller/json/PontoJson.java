package br.com.pupposoft.fiap.sgp.ponto.controller.json;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.pupposoft.fiap.sgp.ponto.domain.Ponto;
import br.com.pupposoft.fiap.sgp.ponto.domain.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PontoJson {
	private Long id;
	private Long userId;
	private String dataHora;
	
	public Ponto getDomain() {
		//2024-03-21T20:29:35.896093573
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddTHH:mm:ss");
		
		return Ponto.builder()
				.id(id)
				.usuario(Usuario.builder().id(userId).build())
				.dataHora(LocalDateTime.parse(dataHora, formatter))
				.build();
	}
}
