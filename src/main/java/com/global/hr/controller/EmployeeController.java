package com.global.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.repository.EmployeeReps;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeReps employeeReps;	
	
	@GetMapping("/count")
	public int countEmployee() {
		return employeeReps.count();
	}
	
}
