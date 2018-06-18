package com.sudarshan.spring.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sudarshan.spring.jdbc.model.Employee;

public class EmployeeMapper  implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setSalary(rs.getInt("salary"));
		employee.setAge(rs.getInt("age"));
		employee.setName(rs.getString("name"));
		
		return employee;
	}

}
