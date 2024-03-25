package br.com.pupposoft.fiap.sgp.ponto.exception;

import br.com.pupposoft.fiap.starter.exception.SystemBaseException;
import lombok.Getter;

@Getter
public class UsuarioNaoEncontadoException extends SystemBaseException {
	private static final long serialVersionUID = 2821685551269014228L;
	
	private final String code = "sgp.usuarioNaoEncontrado";//NOSONAR
	private final String message = "Usuário não foi encontrado";//NOSONAR
	private final Integer httpStatus = 404;//NOSONAR
}
