package com.student.beans;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Student {
	
	private int id;
	private String name;
	private long mobile;
	/*
	 * @DateTimeFormat(pattern = "dd/mm/yyyy")
	 */
	private Date dob;
	private String country;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + ", dob=" + dob + ", country=" + country
				+ "]";
	}
	
	
}
