package com.nt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest1 {

	public static void main(String[] args) throws IOException  {
		
		BufferedReader br =null;
		System.out.println("Enter a number: ");
		
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		finally {
			br.close();
		}
		System.out.println("Number is: "+n);
	}
}
