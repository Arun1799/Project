package com.ems.model;

import java.time.LocalDate;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ems.entity.Department;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO extends UserDTO{

	@NotNull(message="Employee Name cannot be null")
	@NotBlank(message="Employee Name is required")
	@Size(max=20, message="Maximum 20 characters allowed")
	@Size(min=2, message="Minimum 2 values required")
	private String empName;
	
	@NotNull(message="Salary cannot be null")
	private double salary;
	
	@NotNull(message="Phone number cannot be null")
	@NotBlank(message="Phone number is required")
	@Pattern(regexp = "[6789]{1}[0-9]{9}$", message="Phone number should consist of 10 digits")
	private String contact;
	
	@NotNull(message="Email cannot be null")
	@NotBlank(message="Email is required")
	@Email(message="Invalid email")
	private String email;
	
	@NotNull(message="Designation cannot be null")
	@NotBlank(message="Designation is required")
	private String designation;
	
	private LocalDate doj;
	
	@ManyToOne
	private Department dept;
}
