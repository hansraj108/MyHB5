package com.nt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CopyList {

	public static void main(String[] args) {
		
		List<String> courses = Arrays.asList("C","C++","java","Python");
		System.out.println(courses);
		
		List<String> newCor = new ArrayList<>(courses);
		System.out.println(newCor);
		
		List<String> newCor1 = new ArrayList<>();
		newCor1.addAll(courses);
		System.out.println(newCor1);
		
		List<String> newCor2 = new ArrayList<>(courses.size());
		newCor2.add("a");
		newCor2.add("b");
		newCor2.add("c");
		newCor2.add("d");
		Collections.copy(newCor2, courses);
		System.out.println(newCor2);
		
		List<String> newCor3 = courses.stream().collect(Collectors.toList());
		System.out.println(newCor3);
	}

}
