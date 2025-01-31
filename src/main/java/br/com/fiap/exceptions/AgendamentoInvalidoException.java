package br.com.fiap.exceptions;

public class AgendamentoInvalidoException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AgendamentoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}