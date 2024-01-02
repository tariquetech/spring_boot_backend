package com.jala_academy.service;

import java.util.List;

import com.jala_academy.payload.EmployeeDto;
import com.jala_academy.payload.EmployeeResposnse;

public interface EmployeeService {

	 EmployeeDto createEmployee(EmployeeDto employeeDto);
	 
	 List<EmployeeResposnse> getAllEmployee();
	 
	 EmployeeResposnse getEmployeeById(Long id);
	 
	 String deleteEmployee(Long id); 
	 
	 EmployeeDto updateEmployee(EmployeeDto employeeDto, long id);

}
