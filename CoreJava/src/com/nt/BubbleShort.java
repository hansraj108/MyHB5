package com.nt;

import java.util.Arrays;

public class BubbleShort {
	
	public static void main(String[] args) {
		
	
	int[] array = {6,5,4,3,2,1};
	String actual = Arrays.toString(array);
	System.out.println(actual);
	for(int i=0; i<array.length-1;i++) {
		System.out.println("OOOO");
		for(int j=0; j<array.length-1-i;j++) {
			System.out.println("IIII");
		if(array[j]>array[j+1]) {
			int tmp = array[j];
			array[j] = array[j+1];
			array[j+1] = tmp;
		}
		}
	}
	print(Arrays.toString(array));
	}

	private static void print(String s) {
		System.out.println(s);
		
	}
}
