package com.nt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIteration {

	public static void main(String[] args) {

		Set<String> mySet = new HashSet<>();
		mySet.add("hans");
		mySet.add("raj");
		mySet.add("tan");
		mySet.add("del");
		
		System.out.println(mySet);
		
	/*	for(String s:mySet) {
			System.out.println(s);
		}
	*/
		
	//	mySet.stream().forEach(s->System.out.println(s));
		
	//	mySet.forEach(s->System.out.println(s));
		
	/*	 Iterator<String> itr = mySet.iterator();
		 while(itr.hasNext()) {
			 System.out.println(itr.next());
		 }
	*/
	mySet.stream().filter(s->!"hans".equals(s))
	.forEach(s->System.out.println(s));
	}

}
