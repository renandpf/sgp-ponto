package br.com.pupposoft.fiap.sgp.ponto.gateway;

import java.util.List;

import br.com.pupposoft.fiap.sgp.ponto.domain.Ponto;

public interface GeradorDocumentoGateway {

	byte[] gerar(List<Ponto> pontos);

}
