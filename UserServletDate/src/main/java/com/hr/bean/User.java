package com.hr.bean;

public class User {

	private int userDateID;
	private String udate;
	private String name;
	private String address;
	private String married;
	private String designation;
	private String hobies;
	private String gender;
	
	
	public int getUserDateID() {
		return userDateID;
	}
	public void setUserDateID(int userDateID) {
		this.userDateID = userDateID;
	}
	public String getUdate() {
		return udate;
	}
	public void setUdate(String udate) {
		this.udate = udate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMarried() {
		return married;
	}
	public void setMarried(String married) {
		this.married = married;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getHobies() {
		return hobies;
	}
	public void setHobies(String hobies) {
		this.hobies = hobies;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [userDateID=" + userDateID + ", udate=" + udate + ", name=" + name + ", address=" + address
				+ ", married=" + married + ", designation=" + designation + ", hobies=" + hobies + ", gender=" + gender
				+ "]";
	}
	
	

	
	
}
