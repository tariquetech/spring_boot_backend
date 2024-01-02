package com.jala_academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jala_academy.entity.State;
import com.jala_academy.utils.AppConstants;

import java.util.List;

public interface StateRepo extends JpaRepository<State, Integer> {

	@Query(AppConstants.QUERY_FIND_COUNTRY_BY_ID)
	List<State> findByCountryId(@Param(AppConstants.COUNTRY_ID) Integer countryId);
	
}
