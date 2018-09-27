package com.sudarshan.myapp.SpringBootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sudarshan.myapp.SpringBootApp.model.Employee;

/**
 * 
 * @author ksudarshan2
 *
 */
@Repository
public interface EmployeeRepositoty extends CrudRepository<Employee, Long> {
	
	/**
	 * findByName
	 * @param name
	 * @return
	 */
	List<Employee> findByName(String name);
	
	/**
	 * findById
	 * @param id
	 * @return
	 */
	Employee findById(long id);
	
	/**
	 * fetchEmployeesByAgeAndSalary
	 * @param age
	 * @param salary
	 * @return
	 */
	@Query("SELECT emp from Employee emp where emp.age=:age and emp.salary=:salary")
	List<Employee> fetchEmployeesByAgeAndSalary(@Param("age") int age , @Param("salary") int salary);
}
	