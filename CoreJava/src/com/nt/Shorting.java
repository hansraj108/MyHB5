package com.nt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shorting {

	public static void main(String[] args) {
		List<Employee1> list = new ArrayList<>();
		list.add(new Employee1(1,"hans",20,32000));
		
		list.add(new Employee1(3,"tan",22,34000));
		list.add(new Employee1(2,"raj",21,39000));
		list.add(new Employee1(4,"del",23,35000));
		System.out.println(list);
		Collections.sort(list, new MyComparator() {
			@Override
			public int compare(Employee1 e1, Employee1 e2) {
				return (int) (e1.getSalary()-e2.getSalary());
			}
		});
		System.out.println(list);
		
		Collections.sort(list, (e1,e2) -> (int) (e1.getSalary()-e2.getSalary()));
		System.out.println(list);
		
		Collections.sort(list, new MyComparator() {
			@Override
			public int compare(Employee1 e1, Employee1 e2) {
				return (int) (e1.getName().compareTo(e2.getName()));
			}
		});
		System.out.println(list);
		
		Collections.sort(list, (e1,e2)->(int) (e1.getName().compareTo(e2.getName())));
		System.out.println(list);
	}

}
