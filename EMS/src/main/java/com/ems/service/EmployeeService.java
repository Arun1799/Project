package com.ems.service;

import java.util.List;

import com.ems.entity.Employee;
import com.ems.model.EmployeeDTO;

public interface EmployeeService {

	//this method is used to save employee details
	EmployeeDTO saveEmployee(Employee employee);
	//method used to fetch employee details using employee id
	EmployeeDTO getEmployeeById(int empId);
	//method used to fetch all employee details
	List<EmployeeDTO> getAllEmployeeDetails();
	//method used to update employee details using employee id
	EmployeeDTO updateEmpById(int empId, Employee emp);
	//method used to delete employee details using employee id
	void deleteEmpById(int empId);
	//method used to delete all employee details
	void deleteAllEmployees();
	//method used to fetch employee details using employee name
	List<EmployeeDTO> getEmployeeUsingName(String name);
	//method used to fetch employee detail using email
	EmployeeDTO getEmployeeByEmail(String email);
	//method to assign an employee to a department
	EmployeeDTO assignEmpToDept(int empId, int deptId);
	
}
