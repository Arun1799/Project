package com.airline;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.airline.exception.GlobalException;
import com.airline.service.AdminService;
import com.airline.serviceimpl.AdminServiceImpl;

public class App 
{
	static int choice;
	
    public static void main( String[] args ) throws GlobalException
    {
        System.out.println("Welcome to Airline Reservation System");
        do {
        	System.out.println();
        System.out.println("Press:"
        		+ "\n1) Passenger  \n2) Admin  \n3) Exit");
        choice = Integer.parseInt(JOptionPane.showInputDialog("Enter choice:","Type here.."));
        switch(choice)
        {
        case 1:
        	passengerMenu();
        	System.out.println();
        	break;
        	
        case 2:
        	adminFirstMenu();
        	break;
        	
        case 3:
        	System.exit(0);
        	break;
        }
        }
        while(choice!=3);
    }
    
    public static void passengerMenu() throws GlobalException
    {
    	do {
    	System.out.println("Press:\n1) Save new passenger\n2) Get Passenger Details Using Id"
    			+ "\n3) Update passenger details  \n4) Delete passenger using id"
    			+ "\n5) Get Passenger Details Using Email  \n6) Check flight details"
    			+ "\n7) Book a flight \n8) Back to Main Menu");
    	choice = Integer.parseInt(JOptionPane.showInputDialog("Enter choice:","Type here.."));
    	
    	switch(choice)
    	{
    	case 1:
    		PassengerCRUD.registerPassenger();
    		break;
    		
    	case 2:
    		PassengerCRUD.getPassengerById();
    		break;
    		
    	case 3:
    		PassengerCRUD.updatePassenger();
    		break;
    		
    	case 4:
    		PassengerCRUD.deletePassenger();
    		break;
    		
    	case 5:
    		PassengerCRUD.getPassengerByEmail();
    		break;
    		
    	case 6:
    		FlightCRUD.checkFlight();
    		break;
    		
    	case 7:
    		TicketCRUD.bookFlight();
    		break;
    		
    	}
    	
    	}while(choice!=8);
    }
    
    
    public static void airlineMenu()
    {
    	do {
    		System.out.println();
    		System.out.println("Airline Menu");
    		System.out.println("=============");
    		System.out.println("1) Save new airline \n2) Assign flight to airline \n5) Back");
    		choice = Integer.parseInt(JOptionPane.showInputDialog("Enter choice:","Type here.."));
    		switch(choice)
    		{
    		case 1:
    			AirlineCRUD.saveAirline();
    			break;
    			
    		case 2:
    			AirlineCRUD.assignAirlineToFlight();
    			break;
    			
    		}
    	}
    	while(choice!=5);
    }
    
    public static void adminFirstMenu()
    {
    	AdminService aService = new AdminServiceImpl();
    	do {
    		System.out.println();
    		System.out.println("Admin LogIn:");
    		System.out.println("1) LogIn \n2) Back to main menu");
    		choice = Integer.parseInt(JOptionPane.showInputDialog("Enter choice:","Type here.."));
    		switch(choice)
    		{
    		case 1:
    			String user = JOptionPane.showInputDialog("Enter user name:","Type here..");
    			String pass = JOptionPane.showInputDialog("Enter password:","Type here..");
    			boolean value =aService.login(user, pass);
    			if(value == true)
    			{
    				adminMainMenu();
    			}
    			else
    			{
    				JOptionPane.showMessageDialog(null, "Invalid credentials!!");
    				System.exit(0);
    			}
    			break;
    			
    		}
    	}
    	while(choice!=2);
    }
    
    public static void adminMainMenu()
    {
    	do {
    		System.out.println();
    		System.out.println("Admin Main Menu:");
    		System.out.println("1) Admin \n2) Airline \n3) Flight \n4) Back");
    		choice = Integer.parseInt(JOptionPane.showInputDialog("Enter choice:","Type here.."));
    		switch(choice)
    		{
    		case 1:
    			
    			break;
    			
    		case 2:
    			airlineMenu();
    			break;
    			
    		case 3:
    			flightMenu();
    			break;
    			
    		}
    	}
    	while(choice!=4);
    }
    
    public static void flightMenu()
    {
    	do {
    		System.out.println();
    		System.out.println("Flight Menu");
    		System.out.println("=============");
    		System.out.println("1) Save new flight \n5) Back");
    		choice = Integer.parseInt(JOptionPane.showInputDialog("Enter choice:","Type here.."));
    		switch(choice)
    		{
    		case 1:
    			FlightCRUD.saveFlight();
    			break;
    			
    		}
    	}
    	while(choice!=5);
    }
}
