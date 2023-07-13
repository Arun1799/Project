package com.airline;

import javax.swing.JOptionPane;

import com.airline.entity.Admin;
import com.airline.service.AdminService;
import com.airline.serviceimpl.AdminServiceImpl;

public class AdminCRUD {

	static AdminService aService = new AdminServiceImpl();
	
	public static void saveAdmin()
	{
		Admin admin = new Admin();
		
		String name = JOptionPane.showInputDialog("Enter name: ","Type here..");
		String phone = JOptionPane.showInputDialog("Enter phone: ","Type here..");
		String user = JOptionPane.showInputDialog("Enter user name: ","Type here..");
		String password = JOptionPane.showInputDialog("Enter password: ","Type here..");
		
		admin.setName(name);
		admin.setContact(phone);
		admin.setUserName(user);
		admin.setPassword(password);
		admin.setRole("admin");
		
		aService.saveAdmin(admin);
		
	}
}
