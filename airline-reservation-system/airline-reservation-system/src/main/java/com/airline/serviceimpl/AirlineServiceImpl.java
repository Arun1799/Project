package com.airline.serviceimpl;

import com.airline.dao.AirlineDAO;
import com.airline.daoimpl.AirlineDAOImpl;
import com.airline.entity.Airline;
import com.airline.service.AirlineService;

public class AirlineServiceImpl implements AirlineService {

	private AirlineDAO airDao = new AirlineDAOImpl();
	
	@Override
	public String saveAirline(Airline airline) {
		return airDao.saveAirline(airline);
		
//		String str = airDao.saveAirline(airline);
//		return str;
	}

	@Override
	public void assignAirlineToFlight(int flightId, int airlineId) {
		airDao.assignAirlineToFlight(flightId, airlineId);
	}
	
	

}
