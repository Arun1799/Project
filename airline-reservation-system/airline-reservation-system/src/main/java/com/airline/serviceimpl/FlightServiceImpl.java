package com.airline.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.airline.dao.FlightDAO;
import com.airline.daoimpl.FlightDAOImpl;
import com.airline.dto.FlightDTO;
import com.airline.entity.Flight;
import com.airline.service.FlightService;

public class FlightServiceImpl implements FlightService {

	private FlightDAO fDao = new FlightDAOImpl();
	
	@Override
	public void saveFlight(Flight flight) {
		fDao.saveFlight(flight);
	}

	@Override
	public List<Flight> checkFlights(String source, String dest) {
		return fDao.checkFlights(source, dest);
	}

}
