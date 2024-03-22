package br.com.pupposoft.fiap.sgp.ponto.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Ponto {
	private Long id;
	private LocalDateTime dataHora;
	private Usuario usuario;
}
