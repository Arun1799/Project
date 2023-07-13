package com.airline.dto;

import java.util.List;

import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AirlineDTO {

	private int airlineId;
	private String airlineName;
	
	@OneToMany
	private List<FlightDTO> flights;
}
