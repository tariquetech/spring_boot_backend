package com.jala_academy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jala_academy.entity.Skill;

public interface SkillRepo extends JpaRepository<Skill, Long> {

	List<Skill> findByEmployeeId(Long employeeId);
}


