package com.ems.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ems.entity.Department;
import com.ems.entity.Employee;
import com.ems.model.DepartmentDTO;
import com.ems.model.EmployeeDTO;

@Component
public class DepartmentConverter {

	//convert employee entity into employeeDTO
		public DepartmentDTO convertToDeptDTO(Department dept)
		{
			DepartmentDTO deptDto = new DepartmentDTO();
			if(dept!=null)
			{
				BeanUtils.copyProperties(dept, deptDto);
			}
			return deptDto;
		}
		
		//convert employeeDTO to employee entity
		public Department convertToDeptEntity(DepartmentDTO deptDto)
		{
			Department dept = new Department();
			if(deptDto!=null)
			{
				BeanUtils.copyProperties(deptDto, dept);
			}
			return dept;
		}
}
