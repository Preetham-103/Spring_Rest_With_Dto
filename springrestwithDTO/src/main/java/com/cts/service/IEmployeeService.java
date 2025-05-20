package com.cts.service;

import java.util.List;

import com.cts.dto.EmployeeDto;
import com.cts.dto.EmployeeResponseDto;

public interface IEmployeeService {

	EmployeeDto addEmployee(EmployeeDto employeeDto);
	List<EmployeeDto> viewAllEmployee();
	EmployeeDto getEmployeById(int id);
	
	List<EmployeeResponseDto> viewAllEmployeeByAdmin();
	EmployeeDto updateEmployeeById(int id,EmployeeDto employeeDto);
}
