package com.sudarshan.myapp.SpringBootApp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @author ksudarshan2
 *
 */
@Entity
@Table(name="Address")
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "ADDR_ID")
    @GeneratedValue
	private long id;
	
	@Column(name="address_line1")
	private String address_line1;
	
	@Column(name="address_line2")
	private String address_line2;
	
	@Column(name="country")
	private String country;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@Column(name="postal_code")
	private String postal_code;
	
	@Column(name="address_type")
	private String address_type;
	
	public Address()
    {
        super();
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
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER ,cascade= CascadeType.ALL)
    @JoinColumn(name = "emp_id",insertable = false, updatable = false)
    private Employee employee;
	
	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	/**
	 * @return the address_line1
	 */
	public String getAddress_line1() {
		return address_line1;
	}
	/**
	 * @param address_line1 the address_line1 to set
	 */
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	/**
	 * @return the address_line2
	 */
	public String getAddress_line2() {
		return address_line2;
	}
	/**
	 * @param address_line2 the address_line2 to set
	 */
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the postal_code
	 */
	public String getPostal_code() {
		return postal_code;
	}
	/**
	 * @param postal_code the postal_code to set
	 */
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	/**
	 * @return the address_type
	 */
	public String getAddress_type() {
		return address_type;
	}
	/**
	 * @param address_type the address_type to set
	 */
	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}
}
