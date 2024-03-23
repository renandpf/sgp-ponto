package br.com.pupposoft.fiap.sgp.ponto.exception;

import br.com.pupposoft.fiap.starter.exception.SystemBaseException;
import lombok.Getter;

@Getter
public class NotificarException extends SystemBaseException {
	private static final long serialVersionUID = 7523777259462534303L;
	
	private final String code = "sgp.erroAoNotificar";//NOSONAR
	private final String message = "Erro ao notificar";//NOSONAR
	private final Integer httpStatus = 500;//NOSONAR
}
