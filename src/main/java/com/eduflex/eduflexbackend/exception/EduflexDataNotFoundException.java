package com.eduflex.eduflexbackend.exception;

public class EduflexDataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EduflexDataNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public EduflexDataNotFoundException(String message) {
		super(message);
	}
	
}
