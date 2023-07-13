package com.airline.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Airline {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int airlineId;
	
	@Column(name="airline_name", length=30, nullable=false)
	private String airlineName;
	
	@OneToMany
	private List<Flight> flights;
}
