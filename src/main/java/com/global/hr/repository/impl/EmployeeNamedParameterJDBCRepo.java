package com.global.hr.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.mapper.EmployeeMapper;
import com.global.hr.model.Employee;
import com.global.hr.repository.EmployeeReps;

@Component
@Qualifier("employeeNamedParameterJDBCRepo")
public class EmployeeNamedParameterJDBCRepo implements EmployeeReps {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public int count() {

		//return namedParameterJdbcTemplate.queryForObject("select count(*) from employees", Integer.class);
		return 0;
	}

	@Override
	public Employee findById(Long id) {
		return namedParameterJdbcTemplate.queryForObject("select id,name,salary from employees where id=:id",
				new MapSqlParameterSource("id",id),new EmployeeMapper());
	}
	
	@Override
	public List<Employee> findByNameAndSalary(String name, Double salary) {
		MapSqlParameterSource mapParam = new MapSqlParameterSource();
		mapParam.addValue("name",name);
		mapParam.addValue("salary", salary);
		return namedParameterJdbcTemplate.query("select id,name,salary from employees where name=:name and salary=:salary",
				mapParam,new EmployeeMapper());
	}
	@Override
	public List<Employee> findAll() {
		
		return namedParameterJdbcTemplate.query("select id,name,salary from employees",new EmployeeMapper());
		
	}

	@Override
	public int insert(Employee employee) {

		
		return namedParameterJdbcTemplate.update("insert into employees(id,name,salary) values (:employeeId,:name,:salary)",
				new BeanPropertySqlParameterSource(employee));
	}

	@Override
	public int update(Employee employee) {
		
		return namedParameterJdbcTemplate.update("update employess set name=:name,salary=:salary where id=:employeeId",
				new BeanPropertySqlParameterSource(employee));
	}

	@Override
	public int delete(Long id) {

		return namedParameterJdbcTemplate.update("delete from employees where id=:id",new MapSqlParameterSource("id",id));
	}

}
