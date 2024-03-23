package br.com.pupposoft.fiap.sgp.ponto.gateway.http.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.pupposoft.fiap.sgp.ponto.domain.Usuario;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioJson {
	private Long id;
	private String username; 
	
	public Usuario getDomain() {
		return Usuario.builder()
				.id(id)
				.email(username)
				.build();
	}
}
