package com.nt;

import java.util.ArrayList;
import java.util.List;

public class EqualsVs {

	public static void main(String[] args) {
		int i = 5;
		int j = 5;
		String s1 = new String("hans");
		String s2 = new String("hans");
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		System.out.println(i==j);
	//	System.out.println(i.equals(j));
		StringBuffer sb1 = new StringBuffer("hans");
		StringBuffer sb2 = new StringBuffer("hans");
		System.out.println(sb1.toString().equals(sb2.toString()));
		System.out.println(sb1==sb2);
		
		List l1 = new ArrayList();
		l1.add("5");
		l1.add("6");
		l1.add("7");
		l1.add("8");
		l1.add("9");
		
		List l2 = new ArrayList();
		l2.add("5");
		l2.add("6");
		l2.add("7");
		l2.add("8");
		l2.add("9");
		
		System.out.println(l1==l2);
		System.out.println(l1.equals(l2));
		
		
		
	}
}
