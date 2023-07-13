package com.airline.dao;

import com.airline.entity.Airline;

public interface AirlineDAO {

	String saveAirline(Airline airline);
	void assignAirlineToFlight(int flightId, int airlineId);
}
