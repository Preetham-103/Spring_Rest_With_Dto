package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.dto.EmployeeDto;
import com.cts.dto.EmployeeResponseDto;
//import com.cts.service.EmployeeServiceImpl;
import com.cts.service.IEmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	
	@Autowired
	IEmployeeService employeeService;
	
	@PostMapping("/employee")
	ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto)
	{
		return new ResponseEntity<EmployeeDto>(employeeService.addEmployee(employeeDto),HttpStatus.OK);
	}
	
	@GetMapping("/employee")
	ResponseEntity<List<EmployeeDto>> viewAllEmployee()
	{
		return new ResponseEntity<List<EmployeeDto>>(employeeService.viewAllEmployee(),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/employeeAllFields")
	ResponseEntity<List<EmployeeResponseDto>> viewAllEmployeeByAdmin()
	{
		return new ResponseEntity<List<EmployeeResponseDto>>(employeeService.viewAllEmployeeByAdmin(),HttpStatus.OK);
	}
	
	@PutMapping("/employee/{id}")
	ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable int id, @RequestBody EmployeeDto employeeDto)
	{
		return new ResponseEntity<EmployeeDto>(employeeService.updateEmployeeById(id, employeeDto),HttpStatus.OK);
	}
}
