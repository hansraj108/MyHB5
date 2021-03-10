package com.main;

import java.util.Date;

public class BankAccount {

	private int accNo;
	private AcType type ;
	private double balance ;
	private Date openingDate;
	private String CustomerName;
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAccount(int accNo, AcType type, double balance, Date openingDate, String customerName) {
		super();
		this.accNo = accNo;
		this.type = type;
		this.balance = balance;
		this.openingDate = openingDate;
		CustomerName = customerName;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public AcType getType() {
		return type;
	}

	public void setType(AcType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	
	
	
	
}
