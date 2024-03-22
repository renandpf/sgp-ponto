package br.com.pupposoft.fiap.sgp.ponto.gateway;

import java.util.Optional;

import br.com.pupposoft.fiap.sgp.ponto.domain.Ponto;

public interface PontoRepositoryGateway {
	Optional<Ponto> findByUsuarioAndDataHora(Ponto ponto);

	Long criar(Ponto ponto);
}
