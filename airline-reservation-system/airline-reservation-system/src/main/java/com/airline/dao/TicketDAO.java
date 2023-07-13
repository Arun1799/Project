package com.airline.dao;


import com.airline.entity.TicketBooking;

public interface TicketDAO {

	TicketBooking bookFlight(int flightId, int passengerId, TicketBooking ticketBooking);
}
