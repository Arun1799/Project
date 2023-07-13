package com.airline.serviceimpl;

import org.modelmapper.ModelMapper;

import com.airline.dao.PassengerDAO;
import com.airline.daoimpl.PassengerDAOImpl;
import com.airline.dto.PassengerDTO;
import com.airline.entity.Passenger;
import com.airline.exception.GlobalException;
import com.airline.service.PassengerService;

public class PassengerServiceImpl implements PassengerService{

	//accessing the data access layer(DAO) to call the methods
	PassengerDAO passengerDao = new PassengerDAOImpl();
	
	@Override
	public void savePassenger(Passenger passenger) {
		passengerDao.savePassenger(passenger);
	}

	@Override
	public PassengerDTO getPassengerById(int id) throws GlobalException{
		Passenger passenger = passengerDao.getPassengerById(id);
		if(passenger != null)
		{
			return new ModelMapper().map(passenger, PassengerDTO.class);
		}
		else
		{
			throw new GlobalException("Passenger details not found.");
		}
	}

	@Override
	public PassengerDTO updatePassengerById(int id, Passenger passenger) {
		Passenger p = passengerDao.updatePassengerById(id, passenger);
		return new ModelMapper().map(p, PassengerDTO.class); //converting entity to dto
	}

	@Override
	public void deletePassenger(int id) {
		passengerDao.deletePassenger(id);	
	}

	@Override
	public PassengerDTO getPassengerByEmail(String email) {
		Passenger pass = passengerDao.getPassengerByEmail(email);
		return new ModelMapper().map(pass, PassengerDTO.class);
	}

}
