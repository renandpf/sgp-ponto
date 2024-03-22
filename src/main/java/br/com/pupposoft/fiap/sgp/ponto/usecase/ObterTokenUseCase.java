package br.com.pupposoft.fiap.sgp.ponto.usecase;

import org.springframework.stereotype.Service;

import br.com.pupposoft.fiap.sgp.ponto.domain.Usuario;
import br.com.pupposoft.fiap.sgp.ponto.gateway.TokenGateway;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ObterTokenUseCase {
	
	private TokenGateway tokenGateway;

	public String obter(Usuario usuario) {
		return tokenGateway.getToken(usuario);
	}
	
}
