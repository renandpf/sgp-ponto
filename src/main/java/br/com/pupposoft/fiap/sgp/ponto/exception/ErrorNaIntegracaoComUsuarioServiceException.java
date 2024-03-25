package br.com.pupposoft.fiap.sgp.ponto.exception;

import br.com.pupposoft.fiap.starter.exception.SystemBaseException;
import lombok.Getter;

@Getter
public class ErrorNaIntegracaoComUsuarioServiceException extends SystemBaseException {
	private static final long serialVersionUID = 7523777259462534303L;
	
	private final String code = "sgp.erroAcessoUsuarioService";//NOSONAR
	private final String message = "Erro ao acessar usuário service";//NOSONAR
	private final Integer httpStatus = 500;//NOSONAR
}
