package com.nt.beans;

import org.hibernate.validator.constraints.NotEmpty;

public class TextAreaBean {

	@NotEmpty
	String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
