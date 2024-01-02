package com.jala_academy.service;

import java.util.List;

import com.jala_academy.entity.City;

public interface CityService {

	List<City> getCityByStateId(Integer StateId);

}
