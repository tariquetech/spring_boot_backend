package com.jala_academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jala_academy.payload.JWTAuthResponse;
import com.jala_academy.payload.LoginDto;
import com.jala_academy.payload.SignUpDto;
import com.jala_academy.service.AuthService;
import com.jala_academy.utils.AppConstants;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	//Register REST API
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody SignUpDto registerDto) {
		String response = authService.register(registerDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	//Login REST API
	@PostMapping("/login")
	public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto) {
		String token = authService.login(loginDto);

		JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
		jwtAuthResponse.setAccessToken(token);

		return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
	}

	//Forgot Password REST API
	@PostMapping("/forgotP")
	public ResponseEntity<String> handleForgotPwd(@RequestParam(AppConstants.EMAIL) String email) {
		boolean status = authService.forgotPwd(email);
		String flag = "";
		if (status) {
			flag = AppConstants.RESET_PASS_LINK_SENT;
		} else {
			flag = AppConstants.RECORD_NOT_AVAIL;
		}
		return new ResponseEntity<>(flag, HttpStatus.OK);
	}

	//Reset Password REST API
	@PostMapping("/reset-password")
	public ResponseEntity<String> resetPassword(@RequestParam(AppConstants.TOKEN) String token,
			@RequestParam(AppConstants.PASSWORD) String password) {
		authService.resetPassword(token, password);
		return ResponseEntity.ok(AppConstants.RESET_PASS_SUCC);
	}

}
