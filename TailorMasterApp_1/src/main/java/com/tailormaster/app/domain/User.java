package com.tailormaster.app.domain;

public class User {

		private Integer userId;
	    private String firstName;
	    private String lastName;
	    private String phone;
	    private String email;
	    private String address;
	    private String city;
	    private String state;
	    private String country;
	    private String loginName;
	    private String password;
	    private Integer role;
	    private Integer loginStatus;
	    
	    
		public User() {
			
		}


		public User(Integer userId, String firstName, String lastName, String phone, String email, String address,
				String city, String state, String country, String loginName, String password, Integer role,
				Integer loginStatus) {
			super();
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.email = email;
			this.address = address;
			this.city = city;
			this.state = state;
			this.country = country;
			this.loginName = loginName;
			this.password = password;
			this.role = role;
			this.loginStatus = loginStatus;
		}


		public Integer getUserId() {
			return userId;
		}


		public void setUserId(Integer userId) {
			this.userId = userId;
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


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}


		public String getCountry() {
			return country;
		}


		public void setCountry(String country) {
			this.country = country;
		}


		public String getLoginName() {
			return loginName;
		}


		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public Integer getRole() {
			return role;
		}


		public void setRole(Integer role) {
			this.role = role;
		}


		public Integer getLoginStatus() {
			return loginStatus;
		}


		public void setLoginStatus(Integer loginStatus) {
			this.loginStatus = loginStatus;
		}
	    
		
	    
	    
}
