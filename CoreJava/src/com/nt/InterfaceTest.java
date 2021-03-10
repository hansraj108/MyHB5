package com.nt;

interface A8{
	public abstract void m1();
	default void m3() {
		System.out.println("default meth A8");
	}
	
	static void m4() {
		System.out.println("static method A8");
	}
	
}
interface A11{
	public abstract void m1();
	default void m3() {
		System.out.println("default meth A11");
	}
	
	static void m4() {
		System.out.println("static method A11");
	}
	
}
class A10{
	public void m2() {
		System.out.println("m2 method");
	}
}

class A9 extends A10 implements A8,A11{

	
	
	
	@Override
	public void m1() {
		System.out.println("hans");
		
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		A8.super.m3();
	}
	
	
	}
public class InterfaceTest {
	public static void main(String[] args) {
		
	
	A8 a =
		() -> System.out.println("hansaaaaaaaaaaaaaa");
	 
	a.m1();
	a.m3();
	A11.m4();
	
	
	
}
}
