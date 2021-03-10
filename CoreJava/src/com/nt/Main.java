package com.nt;

import java.util.ArrayList;

public class Main {

	
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.setBankName("hans");
		System.out.println(bank.toString());
		
		User user = new User();
		String[] phn = {"123","456","789"};
		user.setAddrs("nvs");
		user.setName("tan");
		user.setPhone(phn);
		bank.setUser(user);
		
		System.out.println(bank.toString());
		
		
}
}