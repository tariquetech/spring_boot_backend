package com.jala_academy.service;

import java.util.List;

import com.jala_academy.entity.State;

public interface StateService {
	
	List<State> getStateByCountryId(Integer CountryId);

}
