package com.sudarshan.myapp.SpringBootApp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sudarshan.myapp.SpringBootApp.model.Employee;
import com.sudarshan.myapp.SpringBootApp.service.EmployeeService;

@RestController
@RequestMapping(value="/employeservice")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Employee.")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value="/employees")
	@ApiOperation("Returns list of all employee in the system.")
	public List<Employee> getEmployees() {
		List<Employee> employeeList = employeeService.getAllEmployees();
		return employeeList;
	}
	
	@GetMapping(value="/employee/{id}")
	@ApiOperation("Returns a specific employee by their identifier. 404 if does not exist.")
	public Employee getEmployeeById(@PathVariable("id")long id) {
		
		Employee emp = employeeService.getEmployeeById(id);
		
		return emp;
	}
	
	@GetMapping(value="/employee/{age}/{salary}")
	@ApiOperation("Returns list of employees by their age and salary. 404 if does not exist.")
	public List<Employee> getEmployeeByAgeAndSalary(@PathVariable("age") int age , @PathVariable("salary") int salary){
		List<Employee> employeeList = employeeService.getEmployeesByAgeAndSalary(age, salary);
		
		return employeeList;
	}
	
	@PostMapping(value="/employee")
	@ApiOperation("Creates a new Employee.")
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee, UriComponentsBuilder builder) {
        
		employeeService.addEmployee(employee);
                
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
}
