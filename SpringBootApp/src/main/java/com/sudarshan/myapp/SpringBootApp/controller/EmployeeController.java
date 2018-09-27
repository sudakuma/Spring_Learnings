package com.sudarshan.myapp.SpringBootApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudarshan.myapp.SpringBootApp.model.Employee;
import com.sudarshan.myapp.SpringBootApp.service.EmployeeService;

@RestController
@RequestMapping(value="/employeservice")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value="/employee")
	public List<Employee> getEmployees() {
		List<Employee> employeeList = employeeService.getAllEmployees();
		return employeeList;
	}
	
	@GetMapping(value="/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id")long id) {
		
		Employee emp = employeeService.getEmployeeById(id);
		
		return emp;
	}
	
	@GetMapping(value="/employee/{age}/{salary}")
	public List<Employee> getEmployeeByAgeAndSalary(@PathVariable("age") int age , @PathVariable("salary") int salary){
		List<Employee> employeeList = employeeService.getEmployeesByAgeAndSalary(age, salary);
		
		return employeeList;
	}
	
}