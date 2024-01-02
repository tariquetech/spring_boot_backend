package com.jala_academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jala_academy.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Integer> {

}
