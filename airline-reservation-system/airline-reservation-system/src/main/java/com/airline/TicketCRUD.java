package com.airline;

import javax.swing.JOptionPane;

import com.airline.dto.TicketBookingDTO;
import com.airline.entity.TicketBooking;
import com.airline.exception.GlobalException;
import com.airline.service.TicketService;
import com.airline.serviceimpl.TicketServiceImpl;

public class TicketCRUD {

	static TicketService tService = new TicketServiceImpl();
	
	public static void bookFlight()
	{
		TicketBooking ticket = new TicketBooking();
		
		int noOfPass = Integer.parseInt(JOptionPane.showInputDialog("Enter no. of passenger:","Type here.."));
		String source = JOptionPane.showInputDialog("Enter source:","Type here..");
		String dest = JOptionPane.showInputDialog("Enter destination:","Type here..");
		
		ticket.setNoOfPassengers(noOfPass);
		ticket.setSource(source);
		ticket.setDestination(dest);
		
		int flightId = Integer.parseInt(JOptionPane.showInputDialog("Enter flight id:","Type here.."));
		int passengerId = Integer.parseInt(JOptionPane.showInputDialog("Enter passenger id:","Type here.."));
				
		TicketBooking dto =tService.bookFlight(flightId, passengerId, ticket);
		
		System.out.println("Flight Id: "+dto.getFlight().getFlightId());
		System.out.println("Date: "+dto.getFlight().getDate());
		System.out.println("Departure Time: "+dto.getFlight().getTime());
		System.out.println("Airline: "+dto.getAirline().getAirlineName());
		System.out.println("Total Fare: "+dto.getTotalFare());
		System.out.println("====================================");
	}
}
