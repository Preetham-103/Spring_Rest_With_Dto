package com.cts.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dto.EmployeeDto;
import com.cts.dto.EmployeeResponseDto;
import com.cts.entity.Employee;
import com.cts.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) {
		Employee employee =  modelMapper.map(employeeDto, Employee.class);
		employee.setCreatedDate(LocalDateTime.now());
		employee.setLastUpdatedDate(LocalDateTime.now());
		employee.setDeleted(false);
		
		Employee savedEmployee =  employeeRepository.save(employee);
		return modelMapper.map(savedEmployee,EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> viewAllEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		
//		List<EmployeeDto> employeeDtos = employees.stream().map(em->modelMapper.map(em, EmployeeDto.class)).collect(Collectors.toList());
		
		
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		for (Employee employee : employees) {
			employeeDtos.add(modelMapper.map(employee, EmployeeDto.class));
		}
		
		return employeeDtos;
	}

	@Override
	public EmployeeDto getEmployeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeResponseDto> viewAllEmployeeByAdmin() {
		List<Employee> employees = employeeRepository.findAll();
		
		List<EmployeeResponseDto> employeeResponseDtos = new ArrayList<>();
		
		for (Employee employee : employees) {
			employeeResponseDtos.add(modelMapper.map(employee, EmployeeResponseDto.class));
		}
		return employeeResponseDtos;
	}

	@Override
	public EmployeeDto updateEmployeeById(int id,EmployeeDto employeeDto) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if(optionalEmployee.isEmpty())
		{
			throw new IllegalArgumentException("no id found");
		}
		
	   Employee employee2= modelMapper.map(employeeDto,Employee.class);
	   employee2.setId(optionalEmployee.get().getId());
	   employee2.setLastUpdatedDate(LocalDateTime.now());
	   
	   return modelMapper.map(employeeRepository.save(employee2), EmployeeDto.class);
	}

}
