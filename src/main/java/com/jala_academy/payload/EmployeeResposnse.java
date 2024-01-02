package com.jala_academy.payload;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResposnse {

	private Long id;
	@NotBlank(message = "First Name is mandatory")
	private String firstName;
	private String lastName;
	@Email(message = "Email is not valid")
	@NotBlank(message = "Email is mandatory")
	private String email;
	@NotBlank(message = "Mobile No is mandatory")
	@Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered ")
	private String mobileNo;
	@NotBlank(message = "Date Of Birth is mandatory")
	private String dob;
	@NotBlank(message = "Gender No is mandatory")
	private String gender;
	@NotBlank(message = "Address No is mandatory")
	@Size(min = 5, message = "Address should have at least 5 characters")
	private String address;
	@NotBlank(message = "Country is mandatory")
	private String country;
	private String state;
	private String city;
	private String otherCity;
	private List<String> skills;

}
