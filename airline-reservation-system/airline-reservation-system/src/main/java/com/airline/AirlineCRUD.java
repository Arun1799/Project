package com.airline;

import javax.swing.JOptionPane;

import com.airline.entity.Airline;
import com.airline.service.AirlineService;
import com.airline.serviceimpl.AirlineServiceImpl;

public class AirlineCRUD {

	static AirlineService aService = new AirlineServiceImpl();
	
	public static void saveAirline()
	{
		Airline airline = new Airline();
		
		String aName = JOptionPane.showInputDialog("Enter airline name:","Type here..");
		
		airline.setAirlineName(aName);
		
//		String str = aService.saveAirline(airline);
//		System.out.println(str);
		
		System.out.println(aService.saveAirline(airline));
	}
	
	public static void assignAirlineToFlight()
	{
		int fId = Integer.parseInt(JOptionPane.showInputDialog("Enter flight id:","Type here.."));
		int aId = Integer.parseInt(JOptionPane.showInputDialog("Enter airline id:","Type here.."));
		
		aService.assignAirlineToFlight(fId, aId);
		JOptionPane.showMessageDialog(null, "Flight id "+fId+" assigned to Airline id "+aId);
	}
}
