package org.cts.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ADDRESS_INFORMATION")
public class Address implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_seq")
	@SequenceGenerator(name = "employee_seq", sequenceName = "employee_sequence")
	@Column(name = "ADDRESS_ID")
	private Integer address_id;
	@Column(name = "HOUSE_NO")
	private String house_no;
	@Column(name = "STREET")
	private String street;
	@Column(name = "CITY")
	private String city;
	@Column(name = "PINCODE")
	private Integer pincode;
	/*
	 * @ManyToOne()
	 * 
	 * @JoinColumn(name = "EMPLOYEE_ID")
	 */
	@ManyToOne()
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Address() {

	}

	public Address(Integer address_id, String house_no, String street,
			String city, Integer pincode, Employee employee) {
		super();
		this.address_id = address_id;
		this.house_no = house_no;
		this.street = street;
		this.city = city;
		this.pincode = pincode;
		this.employee = employee;
	}

}
