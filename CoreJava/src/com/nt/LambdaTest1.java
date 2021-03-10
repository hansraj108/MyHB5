package com.nt;

interface A13{
	void show();
}
public class LambdaTest1 {

	public static void main(String[] args) {
		
		A13 a = () -> System.out.println("hello");
			a.show();
	}
}
