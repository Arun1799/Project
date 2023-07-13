package com.airline;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.airline.entity.Flight;
import com.airline.service.FlightService;
import com.airline.serviceimpl.FlightServiceImpl;

public class FlightCRUD {

	static FlightService fservice = new FlightServiceImpl();
	
	public static void saveFlight()
	{
		Flight f = new Flight();
		
		int total = Integer.parseInt(JOptionPane.showInputDialog("Enter total seat:", "Type here.."));
		int avail = Integer.parseInt(JOptionPane.showInputDialog("Enter available seat:", "Type here.."));
		float fare = Float.parseFloat(JOptionPane.showInputDialog("Enter fare:", "Type here.."));
		String time = JOptionPane.showInputDialog("Enter time:", "Type here..");
		LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Enter date:", "Type here.."));
		String source = JOptionPane.showInputDialog("Enter source:", "Type here..");
		String dest = JOptionPane.showInputDialog("Enter destination:", "Type here..");
		
		f.setTotalSeats(total);
		f.setAvailableSeat(avail);
		f.setFare(fare);
		f.setTime(time);
		f.setDate(date);
		f.setSource(source);
		f.setDestination(dest);
		
		fservice.saveFlight(f);
		System.out.println("Flight details saved successfully.");
	}
	
	public static void checkFlight()
	{
		String s = JOptionPane.showInputDialog("Enter source:","Type here");
		String d = JOptionPane.showInputDialog("Enter destination:","Type here");
		List<Flight> flight = fservice.checkFlights(s, d);
		
		for(Flight f: flight)
		{
			System.out.println("Flight Id: "+f.getFlightId());
			System.out.println("Source: "+f.getSource());
			System.out.println("Destination: "+f.getDestination());
			System.out.println("Available Seats: "+f.getAvailableSeat());
			System.out.println("Departure Time: "+f.getTime());
			System.out.println("Fare: "+f.getFare());
			System.out.println("Date: "+f.getDate());
			System.out.println("Airline: "+f.getAirline().getAirlineName());
			System.out.println("================================");
		}
	}
}
