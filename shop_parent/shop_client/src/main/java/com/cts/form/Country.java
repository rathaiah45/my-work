package com.cts.form;

public class Country {
	Integer id;
	String countryName;

	public Country(Integer id, String countryName) {
		super();
		this.id = id;
		this.countryName = countryName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
