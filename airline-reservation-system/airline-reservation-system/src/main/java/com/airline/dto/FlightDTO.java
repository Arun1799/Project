package com.airline.dto;

import java.time.LocalDate;

import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class FlightDTO {

	private int flightId;
	private int availableSeat;
	private int totalSeats;
	private float fare;
	private String time;
	private LocalDate date;
	private String source;
	private String destination;
	
	@ManyToOne
	private AirlineDTO airline;
}
