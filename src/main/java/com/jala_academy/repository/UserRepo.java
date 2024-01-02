package com.jala_academy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jala_academy.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<User> findByResetToken(String resetToken);
	
}
