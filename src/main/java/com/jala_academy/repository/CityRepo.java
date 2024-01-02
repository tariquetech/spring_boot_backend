package com.jala_academy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jala_academy.entity.City;
import com.jala_academy.utils.AppConstants;

public interface CityRepo extends JpaRepository<City, Integer> {

	@Query(AppConstants.QUERY_FIND_CITY_BY_ID)
	List<City> findByCityId(@Param(AppConstants.STATE_ID) Integer stateId);
	
}
