package com.jala_academy.exception;

import org.springframework.http.HttpStatus;

public class JalaAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;
    
	public JalaAPIException(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public JalaAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }
	
	  public HttpStatus getStatus() {
	        return status;
	    }

	    @Override
	    public String getMessage() {
	        return message;
	    }
    
    
}
