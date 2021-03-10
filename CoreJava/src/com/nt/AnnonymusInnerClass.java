package com.nt;

class A1{
	public void m1() {
		System.out.println("hans is here");
	}
}

/*
 * class A2 extends A1{ public void m1() {
 * System.out.println("hansraj is here"); } }
 */
public class AnnonymusInnerClass {

	public static void main(String[] args) {
		A1 a = new A1() {
			public void m1() {
				System.out.println("hansraj is here");
			}
		};
		a.m1();
	}
}
