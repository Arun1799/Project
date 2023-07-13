package com.airline;

import javax.swing.JOptionPane;

import com.airline.dto.PassengerDTO;
import com.airline.entity.Passenger;
import com.airline.exception.GlobalException;
import com.airline.service.PassengerService;
import com.airline.serviceimpl.PassengerServiceImpl;

public class PassengerCRUD {

 	static PassengerService pService = new PassengerServiceImpl();
	
	//this method is used to register/save passenger details
	public static void registerPassenger()
	{
		Passenger pass = new Passenger();
		
//		pass.setName("Shawin");
//		pass.setEmail("shawin@gmail.com");
//		pass.setPhone("9876543210");
//		pass.setUserName("shawin");
//		pass.setPassword("sha123");
//		pass.setRole("passenger");
		
		String name = JOptionPane.showInputDialog("Enter name: ","Type here..");
		String email = JOptionPane.showInputDialog("Enter email: ","Type here..");
		String phone = JOptionPane.showInputDialog("Enter phone: ","Type here..");
		String user = JOptionPane.showInputDialog("Enter user name: ","Type here..");
		String password = JOptionPane.showInputDialog("Enter password: ","Type here..");
		
		
		pass.setName(name);
		pass.setEmail(email);
		pass.setPhone(phone);
		pass.setUserName(user);
		pass.setPassword(password);
		pass.setRole("passenger");
		
		pService.savePassenger(pass);
		System.out.println("Passenger details saved successfully.");
		
	}
	
	
	public static void getPassengerById() throws GlobalException
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id:","Type here.."));
		PassengerDTO pDTO =pService.getPassengerById(id);
		
		System.out.println("Name: "+pDTO.getName());
		System.out.println("Email: "+pDTO.getEmail());
		System.out.println("Phone: "+pDTO.getPhone());
		System.out.println("User Name: "+pDTO.getUserName());
		System.out.println("Password: "+pDTO.getPassword());
	}
	
	
	public static void updatePassenger() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to update:","Type here.."));
		
		Passenger pass = new Passenger();
		
		String name = JOptionPane.showInputDialog("Enter name: ","Type here..");
		String email = JOptionPane.showInputDialog("Enter email: ","Type here..");
		String phone = JOptionPane.showInputDialog("Enter phone: ","Type here..");
		String user = JOptionPane.showInputDialog("Enter user name: ","Type here..");
		String password = JOptionPane.showInputDialog("Enter password: ","Type here..");
		
		
		pass.setName(name);
		pass.setEmail(email);
		pass.setPhone(phone);
		pass.setUserName(user);
		pass.setPassword(password);
		
		PassengerDTO dto = pService.updatePassengerById(id, pass);
		
		System.out.println("Name: "+dto.getName());
		System.out.println("Email: "+dto.getEmail());
		System.out.println("Phone: "+dto.getPhone());
		System.out.println("User Name: "+dto.getUserName());
		System.out.println("Password: "+dto.getPassword());
	}
	
	
	public static void deletePassenger()
	{
		int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id to delete:","Type here.."));
		
		pService.deletePassenger(id);
	}
	
	
	public static void getPassengerByEmail()
	{
		String email = JOptionPane.showInputDialog("Enter email to search:","Type here..");
		
		PassengerDTO pDTO = pService.getPassengerByEmail(email);
		
		System.out.println("Name: "+pDTO.getName());
		System.out.println("Email: "+pDTO.getEmail());
		System.out.println("Phone: "+pDTO.getPhone());
		System.out.println("User Name: "+pDTO.getUserName());
		System.out.println("Password: "+pDTO.getPassword());
	}
	
}
