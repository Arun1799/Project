package com.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//custom method to get employee details using the employee name
	@Query("from Employee where empName=:name")
	List<Employee> getEmployeeByName(@Param("name") String name);
	
	//custom method to get employee details using the employee email with finder method
	Employee findByEmail(String email);
}
