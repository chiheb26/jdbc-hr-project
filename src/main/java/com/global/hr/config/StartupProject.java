package com.global.hr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeReps;


@Component
public class StartupProject implements CommandLineRunner{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EmployeeReps employeeReps;
	@Override
	public void run(String... args) throws Exception {

		jdbcTemplate.execute("Drop table if exists employees");
		jdbcTemplate.execute("create table employees(id Serial, name varchar(255),salary numeric(15,2))");
		if(employeeReps.count()==0) {
			employeeReps.insert(new Employee(10L,"name1",1200.25));
			employeeReps.insert(new Employee(24L,"name2",2400.16));
			employeeReps.insert(new Employee(13L,"name3",2450.57));
			employeeReps.insert(new Employee(55L,"name4",3250.75));
		}

		
	}
	
	
}
