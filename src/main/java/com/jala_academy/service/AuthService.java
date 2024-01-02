package com.jala_academy.service;

import com.jala_academy.payload.LoginDto;
import com.jala_academy.payload.SignUpDto;

public interface AuthService {
	
    String register(SignUpDto signUpDto);

    String login(LoginDto loginDto);
    
    boolean forgotPwd(String email);
    
    void resetPassword(String resetToken, String newPassword);

}
