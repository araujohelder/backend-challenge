package com.invillia.acme.exceptionhandler;

public class StatusInvalidException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public StatusInvalidException(String message) {
		super(message);
	}
}
