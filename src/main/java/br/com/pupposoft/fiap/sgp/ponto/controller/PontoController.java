package br.com.pupposoft.fiap.sgp.ponto.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pupposoft.fiap.sgp.ponto.controller.json.PontoJson;
import br.com.pupposoft.fiap.sgp.ponto.usecase.ObterTokenUseCase;
import br.com.pupposoft.fiap.sgp.ponto.usecase.RegistrarPontoCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("pontos")
@AllArgsConstructor
public class PontoController {
	
	private ObterTokenUseCase obterTokenUseCase;
	
	private RegistrarPontoCase registrarPontoCase;

	@PostMapping
	public void registrar(@RequestBody PontoJson pontoJson) {
		log.trace("Start pontoJson={}", pontoJson);
		registrarPontoCase.registrar(pontoJson.getDomain());
		log.trace("End");
	}
}
