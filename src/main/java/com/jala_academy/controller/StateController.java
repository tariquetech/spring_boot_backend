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

import com.jala_academy.entity.State;
import com.jala_academy.service.StateService;
import com.jala_academy.utils.AppConstants;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/state")
public class StateController {

	@Autowired
	private StateService stateService;

	@GetMapping("/{countryId}")
	public ResponseEntity<List<State>> getAllCountry(@PathVariable(AppConstants.COUNTRY_ID) Integer id) {

		List<State> state = stateService.getStateByCountryId(id);
		
		return new ResponseEntity<>(state, HttpStatus.OK);
	}

}
