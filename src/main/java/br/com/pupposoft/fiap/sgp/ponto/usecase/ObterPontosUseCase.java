package br.com.pupposoft.fiap.sgp.ponto.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pupposoft.fiap.sgp.ponto.domain.Ponto;
import br.com.pupposoft.fiap.sgp.ponto.domain.Usuario;
import br.com.pupposoft.fiap.sgp.ponto.gateway.GeradorDocumentoGateway;
import br.com.pupposoft.fiap.sgp.ponto.gateway.NotificarGateway;
import br.com.pupposoft.fiap.sgp.ponto.gateway.PontoRepositoryGateway;
import br.com.pupposoft.fiap.sgp.ponto.gateway.UsuarioGateway;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ObterPontosUseCase {
	
	private PontoRepositoryGateway pontoRepositoryGateway;
	
	private UsuarioGateway usuarioGateway;
	
	private GeradorDocumentoGateway documentoGateway;
	
	private NotificarGateway notificarGateway;
	
	public List<Ponto> obterPorIdUsuario(Long userId) {
		return pontoRepositoryGateway.findByUsuario(Usuario.builder().id(userId).build());
	}
	
	public void solicitarEspelhoPontoPorIdUsuario(Long userId) {
		List<Ponto> pontos = obterPorIdUsuario(userId);
		
		byte[] documentoEspelho = documentoGateway.gerar(pontos);
		
		Usuario usuario = usuarioGateway.obtemPorUserId(userId);
		
		notificarGateway.enviar(usuario, documentoEspelho);
	}
	
}
