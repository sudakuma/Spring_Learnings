package com.sudarshan.myapp.SpringBootApp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 
 * @author ksudarshan2
 *
 */
@Entity
@Table(name="Employee")
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	@Column(name="companyname")
	private String companyname;
	
	@Column(name="salary")
	private int salary;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", nullable = false, updatable = false)
	private List<Address> listOfAddress;
	
	
	public Employee()
    {
        super();
    }
	
	/**
	 * @return the listOfAddress
	 */
	public List<Address> getListOfAddress() {
		return listOfAddress;
	}
	/**
	 * @param listOfAddress the listOfAddress to set
	 */
	public void setListOfAddress(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the companyname
	 */
	public String getCompanyname() {
		return companyname;
	}
	/**
	 * @param companyname the companyname to set
	 */
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
