package com.hr;

public class School {

	public static void main(String[] args) {
		PenAdapter pa = new PenAdapter();
		
		AssignmentWork as = new AssignmentWork();
		as.setP(pa);
		as.writeAssignment("hans");
	}
}
