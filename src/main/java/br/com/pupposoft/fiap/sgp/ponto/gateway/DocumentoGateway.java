package br.com.pupposoft.fiap.sgp.ponto.gateway;

import java.util.List;

import br.com.pupposoft.fiap.sgp.ponto.domain.Ponto;

public interface DocumentoGateway {

	byte[] gerarDocumento(List<Ponto> pontos);

}
