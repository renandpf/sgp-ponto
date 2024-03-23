package br.com.pupposoft.fiap.sgp.ponto.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Usuario {
	private Long id;
	private String email;
	
	private List<Ponto> pontos;
}
