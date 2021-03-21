package com.nt;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListIterator {

	public static void main(String[] args) {
		
		List<String> courses = Arrays.asList("C","C++","java","Python");
		
	/*	for(int i=0; i<=courses.size()-1;i++) {
			System.out.println(courses.get(i));
		}
	*/
	/*	 Iterator<String> itr =	courses.iterator();
		 while(itr.hasNext()) {
			 System.out.println(itr.next());
		 }
	*/
	/*	for(String x:courses) {
			System.out.println(x);
		}
	*/
	/*	courses.stream().forEach(x -> System.out.println(x));  */
		
		courses.forEach(x -> System.out.println(x));
			
	}

}
