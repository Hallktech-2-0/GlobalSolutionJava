package br.com.fiap.exceptions;

public class PacienteInvalidoException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PacienteInvalidoException(String mensagem) {
        super(mensagem);
    }
}
