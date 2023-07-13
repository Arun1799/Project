package com.ems.service;

import com.ems.entity.Department;
import com.ems.model.DepartmentDTO;

public interface DepartmentService {

	DepartmentDTO saveDepartment(Department dept);
}
