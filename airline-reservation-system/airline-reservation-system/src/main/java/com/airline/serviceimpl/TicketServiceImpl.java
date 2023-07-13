package com.airline.serviceimpl;

import org.modelmapper.ModelMapper;

import com.airline.dao.TicketDAO;
import com.airline.daoimpl.TicketDAOImpl;
import com.airline.dto.TicketBookingDTO;
import com.airline.entity.TicketBooking;
import com.airline.exception.GlobalException;
import com.airline.service.TicketService;

public class TicketServiceImpl implements TicketService {

	private TicketDAO tDao = new TicketDAOImpl();
	
	@Override
	public TicketBooking bookFlight(int flightId, int passengerId, TicketBooking ticketBooking)
	{
		
		TicketBooking ticket = tDao.bookFlight(flightId, passengerId, ticketBooking);
		return ticket;
		
		//return new ModelMapper().map(ticket, TicketBookingDTO.class);
	}

}
