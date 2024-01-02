package com.jala_academy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "employee_tbl")
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "first_name", nullable = false)
private String firstName;

@Column(name = "last_name", nullable = false)
private String lastName;

@Column(name = "email_address", nullable = false)
private String email;

@Column(name = "mobile_no", nullable = false)
private String mobileNo;

@Column(name = "dob", nullable = false)
private String dob;

@Column(name = "gender", nullable = false)
private String gender;

@Column(name = "address", nullable = false)
private String address;

@Column(name = "country", nullable = false)
private String country;

@Column(name = "state", nullable = false)
private String state;


@Column(name = "city", nullable = false)
private String city;

@Column(name = "other_city", nullable = false)
private String otherCity;

	
}
