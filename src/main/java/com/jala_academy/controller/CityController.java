package com.jala_academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jala_academy.entity.City;
import com.jala_academy.service.CityService;
import com.jala_academy.utils.AppConstants;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/city")

public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping("/{stateId}")
	public ResponseEntity<List<City>> getAllCountry(@PathVariable(AppConstants.STATE_ID) Integer id) {
		List<City> city = cityService.getCityByStateId(id);
		return new ResponseEntity<>(city, HttpStatus.OK);
		
	}

}
