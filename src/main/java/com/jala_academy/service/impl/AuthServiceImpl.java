package com.jala_academy.service.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jala_academy.entity.Role;
import com.jala_academy.entity.User;
import com.jala_academy.exception.JalaAPIException;
import com.jala_academy.payload.LoginDto;
import com.jala_academy.payload.SignUpDto;
import com.jala_academy.repository.RoleRepo;
import com.jala_academy.repository.UserRepo;
import com.jala_academy.security.JwtTokenProvider;
import com.jala_academy.service.AuthService;
import com.jala_academy.utils.AppConstants;
import com.jala_academy.utils.EmailUtils;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepo userRepository;
	@Autowired
	private RoleRepo roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public String register(SignUpDto registerDto) {

		// check username is already exists in database
		if (userRepository.existsByUsername(registerDto.getUsername())) {
			throw new JalaAPIException(HttpStatus.BAD_REQUEST, "Username already exists!");
		}

		// check email is already exists in database
		if (userRepository.existsByEmail(registerDto.getEmail())) {
			throw new JalaAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
		}

		User user = new User();
		user.setName(registerDto.getName());
		user.setUsername(registerDto.getUsername());
		user.setEmail(registerDto.getEmail());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(AppConstants.ROLE_USER).get();
		roles.add(userRole);

		user.setRoles(roles);

		userRepository.save(user);

		return AppConstants.USER_REGISTER_SUCC;
	}

	@Override
	public String login(LoginDto loginDto) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtTokenProvider.generateToken(authentication);

		return token;
	}

	@Override
	public boolean forgotPwd(String email) {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new JalaAPIException(HttpStatus.NOT_FOUND, AppConstants.RECORD_NOT_AVAIL));

		// Generate a unique token
		String resetToken = UUID.randomUUID().toString();
		user.setResetToken(resetToken);

		// Save the user with the reset token
		userRepository.save(user);

		// if record available Send an email with the reset link
		String to = user.getEmail();
		String subject = AppConstants.RESET_PASS;
		String body = resetToken;
		boolean status = emailUtils.sendEmail(to, subject, body);
		return status;
	}

	@Override
	public void resetPassword(String resetToken, String newPassword) {
		User user = userRepository.findByResetToken(resetToken)
				.orElseThrow(() -> new JalaAPIException(HttpStatus.BAD_REQUEST, AppConstants.INVALID_RESET_TOKEN));

		// Update the user's password
		user.setPassword(passwordEncoder.encode(newPassword));
		user.setResetToken(null); // Reset the token

		// Save the updated user
		userRepository.save(user);
	}

}
