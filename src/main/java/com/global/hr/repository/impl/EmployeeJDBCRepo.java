package com.global.hr.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.mapper.EmployeeMapper;
import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeReps;

@Component
public class EmployeeJDBCRepo implements EmployeeReps{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int count() {

		return jdbcTemplate.queryForObject("select count(*) from employees", Integer.class);
	}

	@Override
	public Employee findById(Long id) {
		return jdbcTemplate.queryForObject("select id,name,salary from employees where id=?",
				new Object[]{id},new EmployeeMapper());
	}

	@Override
	public List<Employee> findAll() {
		
		return jdbcTemplate.query("select id,name,salary from employees",new EmployeeMapper());
		
	}

	@Override
	public int insert(Employee employee) {

		
		return jdbcTemplate.update("insert into employees(id,name,salary) values (?,?,?)",
				new Object[] {employee.getId(),employee.getName(),employee.getSalary()});
	}

	@Override
	public int update(Employee employee) {
		
		return jdbcTemplate.update("update employess set name=?,salary=? where id=?",
				new Object[] {employee.getName(),employee.getSalary(),employee.getId()});
	}

	@Override
	public int delete(Long id) {

		return jdbcTemplate.update("delete from employees where id=?",new Object[] {id});
	}

}
