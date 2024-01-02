package com.jala_academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jala_academy.entity.Country;
import com.jala_academy.service.CountryService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/country")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping
	public ResponseEntity<List<Country>> getAllCountry() {
		List<Country> country = countryService.getCountry();
		return new ResponseEntity<>(country, HttpStatus.OK);
	}

}
