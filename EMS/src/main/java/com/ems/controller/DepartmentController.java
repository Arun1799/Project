package com.ems.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Department;
import com.ems.model.DepartmentDTO;
import com.ems.service.DepartmentService;
import com.ems.util.DepartmentConverter;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	@Autowired
	DepartmentService deptService;
	
	@Autowired
	DepartmentConverter deptConverter;

	@PostMapping("/saveDept")
	public DepartmentDTO saveDepartment(@Valid @RequestBody DepartmentDTO deptDTO)
	{
		Department dept = deptConverter.convertToDeptEntity(deptDTO);
		return deptService.saveDepartment(dept);
	}

}
