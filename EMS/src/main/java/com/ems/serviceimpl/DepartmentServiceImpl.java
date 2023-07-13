package com.ems.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Department;
import com.ems.model.DepartmentDTO;
import com.ems.repository.DepartmentRepository;
import com.ems.service.DepartmentService;
import com.ems.util.DepartmentConverter;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository deptRepository;
	
	@Autowired
	DepartmentConverter deptConverter;
	
	@Override
	public DepartmentDTO saveDepartment(Department dept) {
		deptRepository.save(dept);
		return deptConverter.convertToDeptDTO(dept);
	}

}
