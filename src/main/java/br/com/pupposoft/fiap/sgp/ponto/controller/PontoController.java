package br.com.pupposoft.fiap.sgp.ponto.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pupposoft.fiap.sgp.ponto.controller.json.PontoJson;
import br.com.pupposoft.fiap.sgp.ponto.domain.Ponto;
import br.com.pupposoft.fiap.sgp.ponto.usecase.ObterPontosUseCase;
import br.com.pupposoft.fiap.sgp.ponto.usecase.RegistrarPontoCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping
@AllArgsConstructor
public class PontoController {
	
	private ObterPontosUseCase obterPontosUseCase;
	
	private RegistrarPontoCase registrarPontoCase;

	@PostMapping("pontos")
	public void registrar(@RequestBody PontoJson pontoJson) {
		log.trace("Start pontoJson={}", pontoJson);
		registrarPontoCase.registrar(pontoJson.getDomain());
		log.trace("End");
	}
	
	@GetMapping("usuarios/{userId}/pontos")
	public List<PontoJson> listar(@PathVariable("userId") Long userId) {
		log.trace("Start userId={}", userId);
		
		List<Ponto> pontos = obterPontosUseCase.obterPorIdUsuario(userId);
		
		List<PontoJson> pontosJson = pontos.stream().map(PontoJson::new).toList(); 
		
		log.trace("End pontosJson={}", pontosJson);
		
		return pontosJson;
	}
}
