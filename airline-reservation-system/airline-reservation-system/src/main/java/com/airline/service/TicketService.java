package com.airline.service;

import com.airline.entity.TicketBooking;
import com.airline.exception.GlobalException;

public interface TicketService {

	TicketBooking bookFlight(int flightId, int passengerId, TicketBooking ticketBooking);
}
