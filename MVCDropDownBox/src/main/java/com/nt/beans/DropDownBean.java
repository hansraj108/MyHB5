package com.nt.beans;

import org.hibernate.validator.constraints.NotEmpty;

public class DropDownBean {

	@NotEmpty
	String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
