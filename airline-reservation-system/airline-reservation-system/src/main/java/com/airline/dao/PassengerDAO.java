package com.airline.dao;

import com.airline.entity.Passenger;

public interface PassengerDAO {

	void savePassenger(Passenger passenger); //method is used to save passenger details
	Passenger getPassengerById(int id); //method is used to retrieve passenger details using id
	Passenger updatePassengerById(int id, Passenger passenger); //method to update passenger details using id
	void deletePassenger(int id); //method to delete passenger using id
	Passenger getPassengerByEmail(String email); //method to fetch passenger details using email
}
