package br.com.fiap.exceptions;

public class HospitalInvalidoException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HospitalInvalidoException(String mensagem) {
        super(mensagem);
    }
}
