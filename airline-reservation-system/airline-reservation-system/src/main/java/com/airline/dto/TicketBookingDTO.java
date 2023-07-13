package com.airline.dto;

import java.time.LocalDate;

import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketBookingDTO {

	
	private int ticketId;
	
	private int noOfPassengers;
	
	
	private float totalFare;
	
	
	private final LocalDate bookingDate = LocalDate.now();
	
	
	private String source;
	
	
	private String destination;
	
	@OneToOne
	private PassengerDTO passenger;
	
	@OneToOne
	private FlightDTO flight;
	
	@OneToOne
	private AirlineDTO airline;
}
