package org.shop_hibernate.form;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER_DATA")
public class Member implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBER_ID")
	private Integer member_id;
	@Column(name = "FIRST_NAME")
	private String first_name;
	@Column(name = "LAST_NAME")
	private String last_name;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "MOBILE_NUMBER")
	private Integer mobile_number;
	@Column(name = "USER_NAME")
	private String user_name;
	@Column(name = "PASS_WORD")
	private String pass_word;
	@OneToMany(mappedBy = "member")
	private Address address;

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

}
