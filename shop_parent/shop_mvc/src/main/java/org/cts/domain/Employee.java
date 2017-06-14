package org.cts.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_INFORMATION")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//, generator = "employee_seq")
	//@SequenceGenerator(name = "employee_seq", sequenceName = "employee_sequnce")
	@Column(name = "EMPLOYEE_ID")
	private Integer employee_id;
	@Column(name = "FIRST_NAME")
	private String first_name;
	@Column(name = "LAST_NAME")
	private String last_name;
	@Column(name = "JOINING_DATE")
	private Date joining_date;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "MOBILE_NUMBER")
	private Integer mobile_number;
	@OneToMany(cascade=CascadeType.ALL)
	//@Column(name = "ADDRESS_ID")
	private List<Address> address = new ArrayList<Address>();

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(Integer mobile_number) {
		this.mobile_number = mobile_number;
	}

	public List<Address> getAddress() {
		return address;
	}
	
	public void setAddress(List<Address> address) {
		this.address = address;
	}

}
