package com.jala_academy.payload;

import lombok.Data;

@Data
public class LoginDto {
	
	private String usernameOrEmail;
    private String password;

}
