package com.nt;

abstract class A5{
	int t = 5;
	abstract void eat();
	
	void sleep() {
		
	}
}

abstract class A6 extends A5{

	abstract void eat();
}
class A7 extends A6{

	 void eat() {
		 System.out.println("hello");
	 }
}

public class AbstractTest1 {

	public static void main(String[] args) {
		
		A5 a = new A7();
		System.out.println(a.t);
		a.eat();
	}
}
