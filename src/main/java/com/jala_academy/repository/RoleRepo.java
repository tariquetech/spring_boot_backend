package com.jala_academy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jala_academy.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

	Optional<Role> findByName(String name);
}
