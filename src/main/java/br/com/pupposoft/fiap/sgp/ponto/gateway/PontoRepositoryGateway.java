package br.com.pupposoft.fiap.sgp.ponto.gateway;

import java.util.List;
import java.util.Optional;

import br.com.pupposoft.fiap.sgp.ponto.domain.Ponto;
import br.com.pupposoft.fiap.sgp.ponto.domain.Usuario;

public interface PontoRepositoryGateway {
	Optional<Ponto> findByUsuarioAndDataHora(Ponto ponto);
	List<Ponto> findByUsuario(Usuario usuario);
	Long criar(Ponto ponto);
}
