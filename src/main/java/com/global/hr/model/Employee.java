package com.global.hr.model;

public class Employee {
	
	private Long id;
	private String name;
	private double salary;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(Long id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
