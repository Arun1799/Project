package com.airline.dao;

import java.util.List;

import com.airline.entity.Flight;

public interface FlightDAO {

	void saveFlight(Flight flight);
	List<Flight> checkFlights(String source, String dest);
}
