package com.sudarshan.myapp.SpringBootApp.service;

import java.util.List;

import com.sudarshan.myapp.SpringBootApp.model.Employee;

/**
 * 
 * @author ksudarshan2
 *
 */
public interface EmployeeService {
	
	/**
	 * Add Employee
	 * @param article
	 * @return
	 */
	void addEmployee(Employee employee);
	
	/**
	 * Update Employee
	 * @param article
	 */
	void updateEmployee(Employee employee);
	
	
	/**
	 * deleteEmployee
	 * @param id
	 */
    void deleteEmployee(long id);
	
	/**
	 * getAllEmployees
	 * @return
	 */
	List<Employee> getAllEmployees();
	
	 /**
	  * List<Employee>
	  * @return
	  */
	List<Employee> getEmployeesByName(String Name);
	 
	 /**
	  * getEmployeesByAgeAndSalary
	  * @param age
	  * @param salary
	  * @return
	  */
	 List<Employee> getEmployeesByAgeAndSalary(int age , int salary);
	 
	 /**
	  * getArticleById
	  * @param articleId
	  * @return
	  */
	 Employee getEmployeeById(long id);

}
