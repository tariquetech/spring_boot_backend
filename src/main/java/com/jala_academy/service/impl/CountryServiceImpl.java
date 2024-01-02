package com.jala_academy.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jala_academy.entity.Country;
import com.jala_academy.repository.CountryRepo;
import com.jala_academy.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepo countryRepo;

	@Override
	public List<Country> getCountry() {

		List<Country> country = countryRepo.findAll();
		return country.stream().collect(Collectors.toList());

	}

}
