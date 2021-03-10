package com.nt.beans;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationBean {

	@NotEmpty
	@Size(min=1,max=5)
	String password;
	@NotEmpty
	@Size(min=1,max=5)
	String confirmPassword;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
