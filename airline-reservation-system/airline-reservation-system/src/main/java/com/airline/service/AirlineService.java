package com.airline.service;

import com.airline.entity.Airline;

public interface AirlineService {

	String saveAirline(Airline airline);
	void assignAirlineToFlight(int flightId, int airlineId);
}
