package com.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Employee;
import com.ems.model.EmployeeDTO;
import com.ems.service.EmployeeService;
import com.ems.util.EmployeeConverter;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@Autowired
	EmployeeConverter converter;
	
	//build save method using REST API
	@PostMapping("/saveEmployee")
	public EmployeeDTO saveEmployee(@Valid @RequestBody EmployeeDTO empDto)
	{
		final Employee emp = converter.convertToEmpEntity(empDto);
		return empService.saveEmployee(emp);
	}
	
	//build get employee details using id REST API
	@GetMapping("/getEmpById/{empId}")
	public EmployeeDTO getEmpById(@PathVariable("empId") int id)
	{
		return empService.getEmployeeById(id);
	}
	
	//build get all employees details using REST API
	@GetMapping("/getAllEmps")
	public List<EmployeeDTO> getAllEmployees()
	{
		return empService.getAllEmployeeDetails();
	}
	
	@PutMapping("/updateEmp/{empId}")
	public EmployeeDTO updateEmp(@PathVariable("empId") int empId,
		 	@Valid @RequestBody EmployeeDTO empDto)
	{
		final Employee emp = converter.convertToEmpEntity(empDto);
		return empService.updateEmpById(empId, emp);
	}
	
	@DeleteMapping("/deleteEmp/{empId}")
	public ResponseEntity<String> deleteEmpById(@PathVariable("empId") int empId)
	{
		empService.deleteEmpById(empId);
		return new ResponseEntity<String>("Employee details with id "+empId+" deleted successfully.",
				HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAllEmp")
	public ResponseEntity<String> deleteAllEmps()
	{
		empService.deleteAllEmployees();
		return new ResponseEntity<String>("All employee details deleted successfully.",
				HttpStatus.OK);
	}
	
	@GetMapping("/getEmpByName/{name}")
	public List<EmployeeDTO> getEmployeeByName(@PathVariable("name") String name)
	{
		return empService.getEmployeeUsingName(name);
	}
	
	@GetMapping("/getEmpByEmail/{email}")
	public EmployeeDTO getEmployeeByEmail(@PathVariable("email") String email)
	{
		return empService.getEmployeeByEmail(email);
	}
	
	@PostMapping("/assignEmp/{empId}/toDept/{deptId}")
	public EmployeeDTO assignEmpToDept(@PathVariable("empId") int empId,
			@PathVariable("deptId") int deptId)
	{
		return empService.assignEmpToDept(empId, deptId);
	}
	
}
