package br.com.pupposoft.fiap.sgp.ponto.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pupposoft.fiap.sgp.ponto.domain.Ponto;
import br.com.pupposoft.fiap.sgp.ponto.gateway.PontoRepositoryGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class RegistrarPontoCase {

	private PontoRepositoryGateway pontoRepositoryGateway;

	public void registrar(Ponto ponto) {

		Optional<Ponto> pontoOp = pontoRepositoryGateway.findByUsuarioAndDataHora(ponto);
		if(pontoOp.isPresent()) {
			log.warn("Data hora do ponto ja está registrada");
			return;
		}
		
		pontoRepositoryGateway.criar(ponto);
	}
}

