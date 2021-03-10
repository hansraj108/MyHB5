package com.hr;

public class BuilderDesignPatternTest {

	public static void main(String[] args) {
		
	
	Phone p = new PhoneBuilder().setOs("windows").getPhone();
	System.out.println(p);
}
}
