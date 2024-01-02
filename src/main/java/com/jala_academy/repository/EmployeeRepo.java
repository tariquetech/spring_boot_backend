package com.jala_academy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jala_academy.entity.Employee;


public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	 boolean existsByEmail(String email);
	 
	 List<Employee> findByFirstName(String firstName);
	 
	 List<Employee> findByEmail(String email);

}
