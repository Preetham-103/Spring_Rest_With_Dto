package com.cts.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class EmployeeResponseDto {
	private int id;
	private String name;
	private String dept;
	private double salary;
	private String email;
	private LocalDateTime createdDate;
	private LocalDateTime lastUpdatedDate;
	private boolean isDeleted;
}
