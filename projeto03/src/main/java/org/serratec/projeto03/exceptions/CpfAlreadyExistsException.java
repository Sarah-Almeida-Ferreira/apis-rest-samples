package org.serratec.projeto03.exceptions;

public class CpfAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CpfAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CpfAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CpfAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CpfAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CpfAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
