package br.com.fiap.exceptions;

public class ConsultaInvalidaException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConsultaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
