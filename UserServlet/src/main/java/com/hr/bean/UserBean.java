package com.hr.bean;

import java.util.Date;



public class UserBean {

	private int userID;
	private String firstName; 
	private String lastName; 
	private String emailID; 
	private String mobileNO; 
	private String address; 
	private String designation; 
	private String password; 
	private String dob; 
	private String education; 
	private String favColor; 
	private String favWeekDay; 
	private String monthOfBirth; 
	private String timeOfBirth; 
	private String married; 
	private String gender; 
	private String hobies;
	
	
	public UserBean() {
		
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
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


	public String getEmailID() {
		return emailID;
	}


	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}


	public String getMobileNO() {
		return mobileNO;
	}


	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public String getFavColor() {
		return favColor;
	}


	public void setFavColor(String favColor) {
		this.favColor = favColor;
	}


	public String getFavWeekDay() {
		return favWeekDay;
	}


	public void setFavWeekDay(String favWeekDay) {
		this.favWeekDay = favWeekDay;
	}


	public String getMonthOfBirth() {
		return monthOfBirth;
	}


	public void setMonthOfBirth(String monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}


	public String getTimeOfBirth() {
		return timeOfBirth;
	}


	public void setTimeOfBirth(String timeOfBirth) {
		this.timeOfBirth = timeOfBirth;
	}


	public String getMarried() {
		return married;
	}


	public void setMarried(String married) {
		this.married = married;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getHobies() {
		return hobies;
	}


	public void setHobies(String hobies) {
		this.hobies = hobies;
	}


	@Override
	public String toString() {
		return "UserBean [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", emailID="
				+ emailID + ", mobileNO=" + mobileNO + ", address=" + address + ", designation=" + designation
				+ ", password=" + password + ", dob=" + dob + ", education=" + education + ", favColor=" + favColor
				+ ", favWeekDay=" + favWeekDay + ", monthOfBirth=" + monthOfBirth + ", timeOfBirth=" + timeOfBirth
				+ ", married=" + married + ", gender=" + gender + ", hobies=" + hobies + "]";
	}


	
}
