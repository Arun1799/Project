package com.airline.dao;

import com.airline.entity.Admin;

public interface AdminDAO {

	void saveAdmin(Admin admin);
	boolean login(String userName, String password);
	
}
