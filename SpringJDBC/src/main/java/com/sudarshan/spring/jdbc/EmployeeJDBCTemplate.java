package com.sudarshan.spring.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.sudarshan.spring.jdbc.dao.EmployeeDAO;
import com.sudarshan.spring.jdbc.mapper.EmployeeMapper;
import com.sudarshan.spring.jdbc.model.Employee;

public class EmployeeJDBCTemplate implements EmployeeDAO{

	// private JdbcTemplate jdbcTemplateObject;
	//Ref:https://www.tutorialspoint.com/spring/spring_jdbc_example.htm
	private DataSource dataSource;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
    	//this.jdbcTemplateObject = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = namedJdbcTemplate;
    }

	 
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
	}

	public void create(String employeeName, Integer salary, Integer age) {
		String SQL = "insert into Employee (name, salary , age) values (:name, :age, :salary)";
		Map<String,Object> paramMap = new HashMap<String,Object>();  
		paramMap.put("name",employeeName);
		paramMap.put("salary", salary);
		paramMap.put("age", age);
	    namedParameterJdbcTemplate.update( SQL, paramMap);
	    System.out.println("Created Record Name = " + employeeName + " Age = " + age);
	    return;
	}

	public Employee getEmployee(Integer employeeId) {
		
		String SQL = "SELECT * FROM Employee WHERE id = :empid";
		SqlParameterSource namedParameters = new MapSqlParameterSource("empid", employeeId);
		Employee employee = (Employee) namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, new EmployeeMapper());
	  
		return employee;
	}

	public List<Employee> listEmployee() {
		String SQL  = "select * from Employee";
		List<Employee> employeeList  = namedParameterJdbcTemplate.query(SQL , new EmployeeMapper());
		
		return employeeList;
	}

	public void deleteEmployee(Integer employeeId) {
		String SQL = "delete from Employee where id = :employeeId";
		Map<String,Object> paramMap = new HashMap<String,Object>();  
		paramMap.put("id",employeeId);
        namedParameterJdbcTemplate.update(SQL, paramMap);
        System.out.println("Deleted Record with EMPLOYEE ID = " + employeeId );
        
	}

	public void updateEmployee(Integer age,Integer id) {
		String SQL = "update Employee set age = :age where id = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("age", age).addValue("id", id);
		namedParameterJdbcTemplate.update(SQL,namedParameters);
		System.out.println("Updated Record with Employee ID = " + id );
		return;
	}
	
	public void deleteAllEmployees() {
		String SQL = "delete from Employee";
		Map<String,Object> paramMap = new HashMap<String,Object>(); 
        namedParameterJdbcTemplate.update(SQL,paramMap);
	}

}
