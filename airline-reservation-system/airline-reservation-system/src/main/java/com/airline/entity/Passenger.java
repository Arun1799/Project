package com.airline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="passenger_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Passenger extends User{

	@Column(length = 30, nullable=false)
	private String name;
	@Column(length = 10, nullable = false, unique = true)
	private String phone;
	@Column(length = 50, nullable = false, unique = true)
	private String email;
	
}
