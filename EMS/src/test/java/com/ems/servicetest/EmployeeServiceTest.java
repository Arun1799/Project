package com.ems.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ems.entity.Employee;
import com.ems.model.EmployeeDTO;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;
import com.ems.util.EmployeeConverter;

@SpringBootTest
class EmployeeServiceTest {

	@MockBean
	EmployeeRepository empRepository;
	
	@Autowired
	EmployeeConverter converter;
	
	@Autowired
	EmployeeService empService;
	
	Employee emp;
	
	@BeforeEach
	void setUp() throws Exception {
	 emp = Employee.builder().userName("heena")
				.password("heena123")
				.empName("Heena")
				.salary(30000.0)
				.contact("9874653298")
				.designation("Developer")
				.email("heena@gmail.com")
				.doj(LocalDate.of(2023, 8, 20))
				.build();
	}
	
	//test method will test saveEmployee method
	@Test
	@DisplayName("Testing save employee method")
	void testSaveEmployee()
	{
		Mockito.when(empRepository.save(emp)).thenReturn(emp);
		
//		assertThat(empService.saveEmployee(emp).getEmpName())
//		.isEqualTo(converter.convertToEmpDTO(emp).getEmpName());
		assertEquals("Heena", empService.saveEmployee(emp).getEmpName());
	}
	
	@Test
	@DisplayName("Testing get emp details using id")
	void testGetEmpById()
	{
	 	Optional<Employee> opEmp = Optional.of(emp);
		Mockito.when(empRepository.findById(emp.getId())).thenReturn(opEmp);
		
		EmployeeDTO eDto =converter.convertToEmpDTO(opEmp.get());
		assertThat(empService.getEmployeeById(emp.getId()).getSalary()) //30000
		.isEqualTo(eDto.getSalary()); //30000
	}

	@Test
	@DisplayName("Testing update employee method")
	void testUpdateEmployee()
	{
		Optional<Employee> opEmp = Optional.of(emp);
		Employee emp2 = opEmp.get();
		
		Mockito.when(empRepository.findById(emp.getId())).thenReturn(opEmp);
		emp2.setEmpName("Heena Nadaf");
		
		Mockito.when(empRepository.save(emp2)).thenReturn(emp2);
		
		assertEquals("Heena Nadaf", empService.updateEmpById(emp2.getId(), emp2).getEmpName());
		
	}
	
	@Test
	@DisplayName("Negative test case")
	void testNegativeGetEmpById()
	{
	 	Optional<Employee> opEmp = Optional.of(emp);
		Mockito.when(empRepository.findById(emp.getId())).thenReturn(opEmp);
		
		assertThat(empService.getEmployeeById(emp.getId()).getSalary())
		.isEqualTo(35000.0);
	}
	

}
