package com.airline.service;

import java.util.List;

import com.airline.dto.FlightDTO;
import com.airline.entity.Flight;

public interface FlightService {

	void saveFlight(Flight flight);
	List<Flight> checkFlights(String source, String dest);

}
