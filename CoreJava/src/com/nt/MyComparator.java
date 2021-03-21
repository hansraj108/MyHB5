package com.nt;

import java.util.Comparator;

public class MyComparator implements Comparator<Employee1>{

	@Override
	public int compare(Employee1 e1, Employee1 e2) {
		return (int) (e1.getSalary()-e2.getSalary());
	}

}
