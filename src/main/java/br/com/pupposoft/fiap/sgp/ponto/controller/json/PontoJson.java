package br.com.pupposoft.fiap.sgp.ponto.controller.json;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private LocalDateTime dataHora;
	
	
	public PontoJson(Ponto ponto) {
		id = ponto.getId();
		userId = ponto.getUsuario().getId();
		dataHora = ponto.getDataHora();
	}
	
	@JsonIgnore
	public Ponto getDomain() {
		return Ponto.builder()
				.id(id)
				.usuario(Usuario.builder().id(userId).build())
				.dataHora(dataHora)
				.build();
	}
}
