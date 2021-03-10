package com.nt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTestTryWithResource {

	public static void main(String[] args) throws IOException  {
		
		System.out.println("Enter a number: ");
		
		int n = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			n = Integer.parseInt(br.readLine());
		} 
		System.out.println("Number is: "+n);
		
	}
}
