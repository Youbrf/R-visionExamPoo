package icc.be.poo.exception;

public class DuplicateArtistException extends RuntimeException {

	private static final long serialVersionUID = -5688972674646387548L;

	public DuplicateArtistException() {
		super();
	}

	public DuplicateArtistException(String message) {
		super(message);
	}
	
}
