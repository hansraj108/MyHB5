package com.hr.tmapp.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Customer {
	
	private Integer customerId;	//pk
	private Integer userId;	//fk
	private Integer measurementId; //fk
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address;
	private String remark;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer customerId, Integer userId, Integer measurementId, String firstName, String lastName,
			String phone, String address) {
		super();
		this.customerId = customerId;
		this.userId = userId;
		this.measurementId = measurementId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(Integer measurementId) {
		this.measurementId = measurementId;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
