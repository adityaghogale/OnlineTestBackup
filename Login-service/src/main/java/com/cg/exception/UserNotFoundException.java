package com.cg.exception;


/**
 * 
 * @author Aditya Ghogale
 *
 */
public class UserNotFoundException extends RuntimeException {

	private String message;

	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "UserNotFoundException [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
