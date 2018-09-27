package com.sudarshan.myapp.SpringBootApp.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.myapp.SpringBootApp.model.Employee;
import com.sudarshan.myapp.SpringBootApp.repository.EmployeeRepositoty;
import com.sudarshan.myapp.SpringBootApp.service.EmployeeService;

/**
 * 
 * @author ksudarshan2
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepositoty employeeRepositoty;

	@Override
	public List<Employee> getEmployeesByName(String name) {
		List<Employee> employeeList = employeeRepositoty.findByName(name);
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeesByAgeAndSalary(int age, int salary) {
		List<Employee> employeeList = employeeRepositoty.fetchEmployeesByAgeAndSalary(age, salary);
		
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(long id) {
		Employee employee = employeeRepositoty.findById(id);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		Iterator<Employee> iterator = employeeRepositoty.findAll().iterator();
		while(iterator.hasNext()){
			Employee emp = (Employee)iterator.next();
			employeeList.add(emp);
		}
		return employeeList;
	}

	@Override
	public synchronized void addEmployee(Employee employee) {

		employeeRepositoty.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepositoty.save(employee);
		
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepositoty.delete(getEmployeeById(id));
		
	}
}
