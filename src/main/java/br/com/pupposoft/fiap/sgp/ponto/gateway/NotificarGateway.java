package br.com.pupposoft.fiap.sgp.ponto.gateway;

import br.com.pupposoft.fiap.sgp.ponto.domain.Usuario;

public interface NotificarGateway {

	void enviar(Usuario usuario, byte[] documentoEspelho);

}
