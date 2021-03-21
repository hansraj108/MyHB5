package com.nt;

import java.util.HashSet;
import java.util.Set;

public class ArrayTest {

	static void printRepeating(int arr[], int size)
    {
        for(int i=0;i<size;i++) {
        	int j = Math.abs(arr[i]);
        	if (arr[j]>=0)
        		arr[j]=-arr[j];
        	else
        		System.out.println(j +" ");
        }
    }
	
	public static void main(String[] args) {
		
		 
	        int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
	        int arr_size = arr.length;
	 
	        printRepeating(arr, arr_size);
		
}
	
}
