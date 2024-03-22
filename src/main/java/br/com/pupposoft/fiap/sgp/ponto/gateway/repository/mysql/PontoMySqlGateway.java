package br.com.pupposoft.fiap.sgp.ponto.gateway.repository.mysql;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.pupposoft.fiap.sgp.ponto.domain.Ponto;
import br.com.pupposoft.fiap.sgp.ponto.exception.ErroAoAcessarRepositorioDadosException;
import br.com.pupposoft.fiap.sgp.ponto.gateway.PontoRepositoryGateway;
import br.com.pupposoft.fiap.sgp.ponto.gateway.repository.jpa.PontoRepository;
import br.com.pupposoft.fiap.sgp.ponto.gateway.repository.jpa.entity.PontoEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class PontoMySqlGateway implements PontoRepositoryGateway {

	private PontoRepository pontoRepository;

	@Override
	public Optional<Ponto> findByUsuarioAndDataHora(Ponto ponto) {
		try {
			
			Optional<PontoEntity> pontoEntityOp = pontoRepository.findByUsuarioIdAndDataHora(ponto.getUsuario().getId(), ponto.getDataHora());
			
			if(pontoEntityOp.isPresent()) {
				return Optional.of(pontoEntityOp.get().getDomain());
			}
			
			return Optional.empty();
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarRepositorioDadosException();
		}
	}

	@Override
	public Long criar(Ponto ponto) {
		try {
			return pontoRepository.save(new PontoEntity(ponto)).getId();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErroAoAcessarRepositorioDadosException();
		}
	}


}
