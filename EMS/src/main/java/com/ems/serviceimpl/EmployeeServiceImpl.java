package com.ems.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.entity.Role;
import com.ems.exceptions.PropertyAlreadyExistException;
import com.ems.exceptions.ResourceNotFoundException;
import com.ems.model.EmployeeDTO;
import com.ems.repository.DepartmentRepository;
import com.ems.repository.EmployeeRepository;
import com.ems.repository.RoleRepository;
import com.ems.service.EmployeeService;
import com.ems.util.EmployeeConverter;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

	//logger statically created
	private static final Logger log = LoggerFactory.getLogger(Employee.class);
	
	@Autowired
	EmployeeRepository empRepository; //injecting employee repository
	
	@Autowired
	RoleRepository roleRepository; //injecting role repository
	
	@Autowired
	DepartmentRepository deptRepository; //injecting department repository
	
	 //injecting the converter which is used to convert entity to dto and vice versa
	@Autowired
	EmployeeConverter converter;
	
	// method used to save employee details
	@Override
	public EmployeeDTO saveEmployee(Employee employee) throws PropertyAlreadyExistException{
		List<Employee> employees =empRepository.findAll();
		for(Employee e: employees)
		{
			if(e.getEmail().equals(employee.getEmail()))
			{
				log.error("Email was already present");
				throw new PropertyAlreadyExistException("Email Already exists.");
			}
			if(e.getContact().equals(employee.getContact()))
			{
				log.error("Phone Number was already present");
				throw new PropertyAlreadyExistException("Phone Number Already exists.");
			}
		}
		Role role = roleRepository.findById(2).get(); //find the object using the id and get the object
		employee.setRole(role); //setting the object to your employee
		log.info("New employee details "+employee.toString()+" saved at "+new Date());
		empRepository.save(employee); //save the employee details
		return converter.convertToEmpDTO(employee); //return employee details
	}

	//method used to fetch employee details using employee id
	@Override
	public EmployeeDTO getEmployeeById(int empId) throws ResourceNotFoundException{
		Employee emp = empRepository.findById(empId).orElseThrow(()->
		new ResourceNotFoundException("Employee", "Id", empId));
		log.info("Employee details with id "+empId+" was fetched at "+new Date());
		return converter.convertToEmpDTO(emp);
	}

	//method used to get all employee details
	@Override
	public List<EmployeeDTO> getAllEmployeeDetails() {
		List<Employee> employees = empRepository.findAll();
		List<EmployeeDTO> empDto = new ArrayList<>();
		for(Employee e : employees)
		{
			empDto.add(converter.convertToEmpDTO(e));		
		}
		log.info("All employee details were fetched at "+new Date());
		return empDto;
	}

	@Override
	public EmployeeDTO updateEmpById(int empId, Employee emp) throws ResourceNotFoundException{
		Employee existEmp = empRepository.findById(empId).orElseThrow(()->
		new ResourceNotFoundException("Employee", "Id", empId));
		
		//updating the existing employee details with new details
		existEmp.setEmpName(emp.getEmpName());
		existEmp.setContact(emp.getContact());
		existEmp.setDesignation(emp.getDesignation());
		existEmp.setDoj(emp.getDoj());
		existEmp.setEmail(emp.getEmail());
		existEmp.setSalary(emp.getSalary());
		existEmp.setUserName(emp.getUserName());
		existEmp.setPassword(emp.getPassword());
		
		//saving the updated details
		empRepository.save(existEmp);
		
		log.info("Employee with id "+empId+" has been updated to "+existEmp.toString());
		return converter.convertToEmpDTO(existEmp);
	}

	@Override
	public void deleteEmpById(int empId) throws ResourceNotFoundException{
		Optional<Employee> opEmp = empRepository.findById(empId);
		Department dept = opEmp.get().getDept();
		if(dept!=null)
		{
			dept.setTotalEmp(dept.getTotalEmp()-1);
			deptRepository.save(dept);
		}
		if(opEmp.isPresent())
		{
			empRepository.deleteById(empId);
		}
		else
		{
			throw new ResourceNotFoundException("Employee", "Id", empId);
		}
	}

	@Override
	public void deleteAllEmployees() {
		empRepository.deleteAll();
	}

	@Override
	public List<EmployeeDTO> getEmployeeUsingName(String name) {
		List<Employee> employees = empRepository.getEmployeeByName(name);
		List<EmployeeDTO> empDto = new ArrayList<>();
		for(Employee e : employees)
		{
			empDto.add(converter.convertToEmpDTO(e));		
		}
		return empDto;
	}

	@Override
	public EmployeeDTO getEmployeeByEmail(String email) throws ResourceNotFoundException{
		Employee emp = empRepository.findByEmail(email);
		if(emp!=null)
		{
		return converter.convertToEmpDTO(emp);
		}
		else
		{
			throw new ResourceNotFoundException("Employee", "Email", email);
		}
	}

	@Override
	public EmployeeDTO assignEmpToDept(int empId, int deptId) throws ResourceNotFoundException{
		Employee emp = empRepository.findById(empId).orElseThrow(()->
		new ResourceNotFoundException("Employee", "Id", empId));
		
		Department dept = deptRepository.findById(deptId).orElseThrow(()->
		new ResourceNotFoundException("Department", "Id", deptId));
		
		emp.setDept(dept);
		
		dept.setTotalEmp(dept.getTotalEmp()+1);
		
		empRepository.save(emp);
		deptRepository.save(dept);
		
		return converter.convertToEmpDTO(emp);
	}

}
