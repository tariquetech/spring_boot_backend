package com.jala_academy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jala_academy.payload.EmployeeDto;
import com.jala_academy.payload.EmployeeResposnse;
import com.jala_academy.service.EmployeeService;
import com.jala_academy.utils.AppConstants;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employeDto) {
		EmployeeDto newEmpData = employeeService.createEmployee(employeDto);
		return new ResponseEntity<>(newEmpData,HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@Valid @RequestBody EmployeeDto employeDto, @PathVariable(AppConstants.ID) Long empId) {
		EmployeeDto newEmpData = employeeService.updateEmployee(employeDto, empId);
		
		return new ResponseEntity<>(newEmpData,HttpStatus.CREATED);
	}	
	
	@GetMapping
	public ResponseEntity<List<EmployeeResposnse>> getAllEmployee() {
		List<EmployeeResposnse> allEmployee = employeeService.getAllEmployee();
		return new ResponseEntity<>(allEmployee,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResposnse> getEmployee(@PathVariable(AppConstants.ID) Long empId) {
		 EmployeeResposnse employeeById = employeeService.getEmployeeById(empId);
		return new ResponseEntity<>(employeeById,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delteEmployee(@PathVariable(AppConstants.ID) Long empId) {
		System.out.println(empId);
		String deleteEmployee = employeeService.deleteEmployee(empId);
		return new ResponseEntity<>(deleteEmployee,HttpStatus.OK);
	}
	

		
}