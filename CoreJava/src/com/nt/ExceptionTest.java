package com.nt;

class A12{
	int i=10;
	int j = 0;
	
	public void m1() {
		try {
		System.out.println(i/j);
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}
	}
	
}

public class ExceptionTest {
	
	
	
	public static void main(String[] args) {
		try {
		int i = 9;
		int j = 0;
		int k = i/j;
		
		System.out.println(k);
	//	System.out.println("Bye");
				
		}catch(ArithmeticException e) {
			System.err.println("error");
		}
		finally {
		System.out.println("Bye");
		}
		
	}

}
