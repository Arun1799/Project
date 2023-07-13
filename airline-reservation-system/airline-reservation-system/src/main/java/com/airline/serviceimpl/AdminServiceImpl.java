package com.airline.serviceimpl;

import com.airline.dao.AdminDAO;
import com.airline.daoimpl.AdminDAOImpl;
import com.airline.entity.Admin;
import com.airline.service.AdminService;

public class AdminServiceImpl implements AdminService {

	private AdminDAO adao = new AdminDAOImpl();
	
	@Override
	public void saveAdmin(Admin admin) {
		adao.saveAdmin(admin);

	}

	@Override
	public boolean login(String userName, String password) {
		return adao.login(userName, password);
	}

}
