package com.sudarshan.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sudarshan.spring.jdbc.model.Employee;

/**
 * 
 * @author SUDARSHAN
 *
 */
public class MainApp {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext applicationContext  =  new ClassPathXmlApplicationContext("beans.xml");
		
		EmployeeJDBCTemplate employeeJDBCTemplate = (EmployeeJDBCTemplate) applicationContext.getBean("employeeJDBCTemplate");
		
		System.out.println("------Records Creation--------" );
		employeeJDBCTemplate.create("Sudarshan", 10000, 30);
		employeeJDBCTemplate.create("Indrajeet", 20000, 26);
		employeeJDBCTemplate.create("Anil Kumar Thakur", 32000, 60);
		
		System.out.println("------Listing Multiple Records--------" );
	    
		List<Employee> employees = employeeJDBCTemplate.listEmployee();
	      
        for (Employee record : employees) {
	         System.out.print("ID : " + record.getId() );
	         System.out.print(", Name : " + record.getName() );
	         System.out.println(", Age : " + record.getAge());
        }

	    System.out.println("----Updating Record with ID = 16 -----" );
	    employeeJDBCTemplate.updateEmployee(39, 16);

	    System.out.println("----Listing Record with ID = 16 -----" );
	    Employee Employee = employeeJDBCTemplate.getEmployee(16);
	    System.out.print("ID : " + Employee.getId() );
	    System.out.print(", Name : " + Employee.getName() );
	    System.out.println(", Age : " + Employee.getAge());
	    
	    //System.out.println("----Deleting all  Record with from Employee table -----" );
	    //employeeJDBCTemplate.deleteAllEmployees();
	}

}
