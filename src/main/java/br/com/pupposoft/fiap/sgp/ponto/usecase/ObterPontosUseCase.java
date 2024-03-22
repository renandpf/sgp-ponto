package br.com.pupposoft.fiap.sgp.ponto.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pupposoft.fiap.sgp.ponto.domain.Ponto;
import br.com.pupposoft.fiap.sgp.ponto.domain.Usuario;
import br.com.pupposoft.fiap.sgp.ponto.gateway.PontoRepositoryGateway;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ObterPontosUseCase {
	
	private PontoRepositoryGateway pontoRepositoryGateway;
	
	public List<Ponto> obterPorIdUsuario(Long userId) {
		return pontoRepositoryGateway.findByUsuario(Usuario.builder().id(userId).build());
	}
	
}
