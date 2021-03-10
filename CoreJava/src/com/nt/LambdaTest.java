package com.nt;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(4,5,6,7);
		
		long startTime = System.currentTimeMillis();
		for(int i=0; i<l.size();i++) {
			System.out.println(l.get(i));
		}
		long stopTime = System.currentTimeMillis();
		System.out.println(stopTime - startTime);
		
		long startTime1 = System.currentTimeMillis();
		for(int i : l) {
			System.out.println(i);
		}
		long stopTime1 = System.currentTimeMillis();
		System.out.println(stopTime1 - startTime1);
		
		long startTime2 = System.currentTimeMillis();
		l.forEach(i -> System.out.println(i));
		long stopTime2 = System.currentTimeMillis();
		System.out.println(stopTime2 - startTime2);
		
		
	}
}
