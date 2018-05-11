package ar.edu.unlp.pasae.pasaepracticabackend.exception;

public class PersonNotFoundException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonNotFoundException() {
		super("La persona no esta registrada en el sistema");
	}

}
