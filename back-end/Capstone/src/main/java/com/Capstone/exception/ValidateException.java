package com.Capstone.exception;

public class ValidateException extends Exception {
	
	private String message;

	public ValidateException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	 

}
