package com.jala_academy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jala_academy.entity.State;
import com.jala_academy.repository.StateRepo;
import com.jala_academy.service.StateService;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepo stateRepo;

	@Override
	public List<State> getStateByCountryId(Integer CountryId) {

		List<State> state = stateRepo.findByCountryId(CountryId);
		return state;
	}

}
