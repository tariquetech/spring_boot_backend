package com.jala_academy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jala_academy.entity.Employee;
import com.jala_academy.entity.Skill;
import com.jala_academy.exception.EmailAlreadyExistException;
import com.jala_academy.exception.ResourceNotFoundException;
import com.jala_academy.payload.EmployeeDto;
import com.jala_academy.payload.EmployeeResposnse;
import com.jala_academy.repository.EmployeeRepo;
import com.jala_academy.repository.SkillRepo;
import com.jala_academy.service.EmployeeService;
import com.jala_academy.utils.AppConstants;

@Service
public class EmployeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private SkillRepo skillRepo;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		boolean existsEmail = employeeRepo.existsByEmail(employeeDto.getEmail());
		if (existsEmail) {
			throw new EmailAlreadyExistException(AppConstants.EMPLOYEE, AppConstants.EMAIL, employeeDto.getEmail());
		}

		Employee emp = new Employee();

		emp.setFirstName(employeeDto.getFirstName());
		emp.setLastName(employeeDto.getLastName());
		emp.setEmail(employeeDto.getEmail());
		emp.setMobileNo(employeeDto.getMobileNo());
		emp.setDob(employeeDto.getDob());
		emp.setGender(employeeDto.getGender());
		emp.setAddress(employeeDto.getAddress());
		emp.setCountry(employeeDto.getCountry());
		emp.setState(employeeDto.getState());
		emp.setCity(employeeDto.getCity());
		emp.setOtherCity(employeeDto.getOtherCity());

		Employee newEmployee = employeeRepo.save(emp);

		List<String> newSkill = new ArrayList<>();

		for (String s : employeeDto.getSkills()) {
			Skill skill = new Skill();
			skill.setName(s);
			skill.setEmployee(newEmployee);
			newSkill.add(skill.getName());

			skillRepo.save(skill);
		}

		EmployeeDto empDto = mapToDTO(newEmployee);

		empDto.setFirstName(newEmployee.getFirstName());
		empDto.setLastName(newEmployee.getLastName());
		empDto.setEmail(newEmployee.getEmail());
		empDto.setMobileNo(newEmployee.getMobileNo());
		empDto.setDob(newEmployee.getDob());
		empDto.setGender(newEmployee.getGender());
		empDto.setAddress(newEmployee.getAddress());
		empDto.setCountry(newEmployee.getCountry());
		empDto.setState(newEmployee.getState());
		empDto.setCity(newEmployee.getCity());
		empDto.setOtherCity(newEmployee.getOtherCity());
		empDto.setSkills(newSkill);

		return empDto;
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, long id) {

		Employee emp = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(AppConstants.EMPLOYEE, AppConstants.ID, id));

		List<Skill> findByEmployeeId = skillRepo.findByEmployeeId(id);

		for (Skill skill : findByEmployeeId) {
			skillRepo.deleteById(skill.getId());
			System.out.println(skill.getId());
		}


		emp.setFirstName(employeeDto.getFirstName());
		emp.setLastName(employeeDto.getLastName());
		emp.setEmail(employeeDto.getEmail());
		emp.setMobileNo(employeeDto.getMobileNo());
		emp.setDob(employeeDto.getDob());
		emp.setGender(employeeDto.getGender());
		emp.setAddress(employeeDto.getAddress());
		emp.setCountry(employeeDto.getCountry());
		emp.setCity(employeeDto.getCity());
		emp.setOtherCity(employeeDto.getOtherCity());

		Employee newEmployee = employeeRepo.save(emp);

		List<String> newSkill = new ArrayList<>();

		for (String s : employeeDto.getSkills()) {

			Skill skill = new Skill();
			skill.setName(s);
			skill.setEmployee(newEmployee);
			newSkill.add(skill.getName());

			skillRepo.save(skill);
		}

		EmployeeDto empDto = new EmployeeDto();

		empDto.setFirstName(newEmployee.getFirstName());
		empDto.setLastName(newEmployee.getLastName());
		empDto.setEmail(newEmployee.getEmail());
		empDto.setMobileNo(newEmployee.getMobileNo());
		empDto.setDob(newEmployee.getDob());
		empDto.setGender(newEmployee.getGender());
		empDto.setAddress(newEmployee.getAddress());
		empDto.setCountry(newEmployee.getCountry());
		empDto.setCity(newEmployee.getCity());
		empDto.setOtherCity(newEmployee.getOtherCity());
		empDto.setSkills(newSkill);

		return empDto;
	}

	@Override
	public List<EmployeeResposnse> getAllEmployee() {

		List<Employee> employeeData = employeeRepo.findAll();

		List<EmployeeResposnse> emp = employeeData.stream().map(employeeD -> mapToDTOs(employeeD))
				.collect(Collectors.toList());

		return emp;
	}

	@Override
	public EmployeeResposnse getEmployeeById(Long id) {

		Employee empData = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.EMPLOYEE, AppConstants.ID, id));

		return mapToDTOs(empData);
	}

	@Override
	public String deleteEmployee(Long id) {

		Employee empData = employeeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(AppConstants.EMPLOYEE, AppConstants.ID, id));
	

		List<Skill> findByEmployeeId = skillRepo.findByEmployeeId(id);

		for (Skill skill : findByEmployeeId) {
			skillRepo.deleteById(skill.getId());
			System.out.println(skill.getId());
		}
		employeeRepo.deleteById(id);

		return AppConstants.EMPLOYEE_SPACE + empData.getFirstName() + AppConstants.DELETE_SUCC;
	}

	// convert Entity into DTO
	private EmployeeDto mapToDTO(Employee emp) {
		EmployeeDto empDto = new EmployeeDto();

		empDto.setFirstName(emp.getFirstName());
		empDto.setLastName(emp.getLastName());
		empDto.setEmail(emp.getEmail());
		empDto.setMobileNo(emp.getMobileNo());
		empDto.setDob(emp.getDob());
		empDto.setGender(emp.getGender());
		empDto.setAddress(emp.getAddress());
		empDto.setCountry(emp.getCountry());
		empDto.setCity(emp.getCity());
		empDto.setOtherCity(emp.getOtherCity());
		List<String> newSkill = new ArrayList<>();
		List<Skill> findByEmployeeId = skillRepo.findByEmployeeId(emp.getId());
		for (Skill skill : findByEmployeeId) {

			newSkill.add(skill.getName());
		}

		empDto.setSkills((newSkill));

		return empDto;
	}

	// convert Entity into DTO
	private EmployeeResposnse mapToDTOs(Employee emp) {
		EmployeeResposnse empDto = new EmployeeResposnse();

		empDto.setId(emp.getId());
		empDto.setFirstName(emp.getFirstName());
		empDto.setLastName(emp.getLastName());
		empDto.setEmail(emp.getEmail());
		empDto.setMobileNo(emp.getMobileNo());
		empDto.setDob(emp.getDob());
		empDto.setGender(emp.getGender());
		empDto.setAddress(emp.getAddress());
		empDto.setCountry(emp.getCountry());
		empDto.setCity(emp.getCity());
		empDto.setState(emp.getState());
		empDto.setOtherCity(emp.getOtherCity());
		List<String> newSkill = new ArrayList<>();
		List<Skill> findByEmployeeId = skillRepo.findByEmployeeId(emp.getId());
		for (Skill skill : findByEmployeeId) {

			newSkill.add(skill.getName());
		}

		empDto.setSkills((newSkill));

		return empDto;
	}

}
