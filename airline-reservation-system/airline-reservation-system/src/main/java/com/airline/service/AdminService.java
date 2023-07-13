package com.airline.service;

import com.airline.entity.Admin;

public interface AdminService {

	void saveAdmin(Admin admin);
	boolean login(String userName, String password);
}
