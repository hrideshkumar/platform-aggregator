package com.profile.exception;

public class InvalidRequest extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public InvalidRequest(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
}
