package com.nt;

interface A2{
	void m1();
}

/*
 * class A3 implements A2{
 * 
 * @Override public void m1() { System.out.println("hans is here");
 * 
 * }
 * 
 * }
 */
public class AnnonymusInnerClassInterface {
	
	public static void main(String[] args) {
		
	
//	A2 a = new A3();
	A2 a = new A2() {

		@Override
		public void m1() {
			System.out.println("hansraj is here");
			
		}
		
	};
	a.m1();
}
}
