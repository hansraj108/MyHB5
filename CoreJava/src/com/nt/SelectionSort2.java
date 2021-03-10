package com.nt;

import java.util.Arrays;

public class SelectionSort2 {

	public static void main(String[] args) {
		
		int[] a = {14, 17, 87, 54, 25, 4, 36};
		
		for(int i=0; i<a.length; i++) {
			int min=i; int temp;
			for(int j=i+1; j<a.length; j++) {
				if(a[j]<a[min]) {
					min=j;
				}
			}
			temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		for(int i=0; i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
}
