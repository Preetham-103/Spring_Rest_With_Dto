package com.cts.entity;

import java.time.LocalDateTime;
//import java.util.concurrent.StructuredTaskScope.Subtask;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="emp51")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String dept;
	private double salary;
	private String email;
	private LocalDateTime createdDate;
	private LocalDateTime lastUpdatedDate;
	private boolean isDeleted;
	
	
}
