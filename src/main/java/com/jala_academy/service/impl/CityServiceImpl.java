package com.jala_academy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jala_academy.entity.City;
import com.jala_academy.repository.CityRepo;
import com.jala_academy.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepo cityRepo;

	@Override
	public List<City> getCityByStateId(Integer StateId) {
		List<City> cities = cityRepo.findByCityId(StateId);
		return cities;
	}

}
