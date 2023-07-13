package com.ems.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee extends User{

	@Column(length=20, nullable = false)
	private String empName;
	
	@Column(nullable = false)
	private double salary;
	
	@Column(length=10, nullable = false, unique = true)
	private String contact;
	
	@Column(length=30, nullable = false, unique=true)
	private String email;
	
	@Column(length=20, nullable = false)
	private String designation;
	
	@Column
	private LocalDate doj;
	
	@ManyToOne //many employees can work under one department
	private Department dept;

	@Builder
	public Employee(int id, String userName, String password, Role role, String empName, double salary, String contact,
			String email, String designation, LocalDate doj, Department dept) {
		super(id, userName, password, role);
		this.empName = empName;
		this.salary = salary;
		this.contact = contact;
		this.email = email;
		this.designation = designation;
		this.doj = doj;
		this.dept = dept;
	}
	
	
}
