package com.nt.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationBean {
	
	@NotEmpty(message="FirstName cannot be empty")
	@Size(min=1,max=6,message="Size should be between 1 to 6")
	String firstName;
	
	@NotNull
	@Size(min=1,max=6,message="Size should be between 1 to 6")
	String lastName;
	
	@NotEmpty(message="Email Address cannot be empty")
	@Email(message="Please enter a valid email address")
	String email;
	
	String profession;
	
	@NotEmpty(message="Atleast one hobby has to be selected")
	String[] hobby;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	
	
	

}
