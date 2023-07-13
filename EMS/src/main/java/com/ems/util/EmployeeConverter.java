package com.ems.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ems.entity.Employee;
import com.ems.model.EmployeeDTO;

@Component
public class EmployeeConverter {

	//convert employee entity into employeeDTO
	public EmployeeDTO convertToEmpDTO(Employee emp)
	{
		EmployeeDTO eDto = new EmployeeDTO();
		if(emp!=null)
		{
			BeanUtils.copyProperties(emp, eDto);
		}
		return eDto;
	}
	
	//convert employeeDTO to employee entity
	public Employee convertToEmpEntity(EmployeeDTO eDto)
	{
		Employee emp = new Employee();
		if(eDto!=null)
		{
			BeanUtils.copyProperties(eDto, emp);
		}
		return emp;
	}
}
