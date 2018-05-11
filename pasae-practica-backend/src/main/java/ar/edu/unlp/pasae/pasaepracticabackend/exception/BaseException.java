package ar.edu.unlp.pasae.pasaepracticabackend.exception;

public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;

	public BaseException(final String message, final Exception exception) {
		super(message, exception);
	}

	public BaseException(String message) {
		super(message);
	}

}
