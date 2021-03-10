package com.nt;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		
		int[] a = {14, 17, 87, 54, 25, 36};
		int temp;
		int outerCount=0, innerCount=0;
		for(int i=0; i<a.length;i++) {
			outerCount++;
			int min = i;
			for(int j=i+1; j<a.length; j++) {
				innerCount++;
				if(a[j]<a[min]) {
					min=j;
				}
			}
			temp = a[i];
			a[i] = a[min];
			a[min] = temp;
			
		}
		for(int i=0; i<a.length;i++)
		System.out.println(a[i]);
		System.out.println("outerCount "+outerCount);
		System.out.println("innerCount "+innerCount);
	}
}
