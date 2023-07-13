package com.airline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User{

	@Column(length = 30, nullable = false)
	private String name;
	@Column(length = 10, nullable = false, unique = true)
	private String contact;
}
