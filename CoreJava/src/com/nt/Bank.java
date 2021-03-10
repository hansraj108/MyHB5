package com.nt;

public class Bank {

	private String bankName;
	private User user;
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(String bankName, User user) {
		super();
		this.bankName = bankName;
		this.user = user;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("bankName :"+bankName+" user "+user);
	}

	
	
	
}
