package com.jala_academy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jala_academy.utils.AppConstants;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmailAlreadyExistException extends RuntimeException{
	
	private String resourceName;
    private String fieldName;
    private String email;
    
	public EmailAlreadyExistException(String resourceName, String fieldName, String email) {
		super(String.format(AppConstants.ALREADY_EXIST_WITH_PER, resourceName, fieldName, email));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.email = email;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getEmail() {
		return email;
	}
    
    

}
