package com.sudarshan.spring.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.sudarshan.spring.jdbc.model.Employee;

/**
 * @author SUDARSHAN
 *
 */
public interface EmployeeDAO {

	/** 
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
	public void setDataSource(DataSource ds);
	
	/** 
     * This is the method to be used to create
     * a record in the Employee table.
    */
	public void create(String employeeName , Integer salary, Integer age);
	
	/** 
     * This is the method to be used to list down
     * a record from the Employee table corresponding
     * to a passed employee id.
    */
	public Employee getEmployee(Integer employeeId);
	
	/** 
     * This is the method to be used to list down
     * all the records from the Empployee table.
    */
	public List<Employee> listEmployee();
	
	/** 
     * This is the method to be used to delete
     * a record from the Employee table corresponding
     * to a passed employye id.
    */
	public void deleteEmployee(Integer employeeId);
	
	
	/** 
     * This is the method to be used to update
     * a record into the Employee table.
    */
	public void updateEmployee(Integer employeeId , Integer age);
}
