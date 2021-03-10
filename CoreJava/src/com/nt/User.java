package com.nt;

public class User {

	private String name;
	private String addrs;
	private String[] phone;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String addrs, String[] phone) {
		super();
		this.name = name;
		this.addrs = addrs;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	public String[] getPhone() {
		return phone;
	}

	public void setPhone(String[] phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
