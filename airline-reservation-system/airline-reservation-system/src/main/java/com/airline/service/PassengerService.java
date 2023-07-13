package com.airline.service;

import com.airline.dto.PassengerDTO;
import com.airline.entity.Passenger;
import com.airline.exception.GlobalException;

public interface PassengerService {

	void savePassenger(Passenger passenger);
	PassengerDTO getPassengerById(int id) throws GlobalException;
	PassengerDTO updatePassengerById(int id, Passenger passenger);
	void deletePassenger(int id);
	PassengerDTO getPassengerByEmail(String email);
}
