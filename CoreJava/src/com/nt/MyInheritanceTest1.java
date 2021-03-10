package com.nt;

import java.io.IOException;

class MyIn1{
	
	public MyIn1(String s) throws IOException {
		System.out.println("MyIn1");
	}
}
class MyIn2 extends MyIn1 {
	public MyIn2(String s) throws Exception{
		super(s);
		System.out.println("MyIn2");
	}
}

public class MyInheritanceTest1 {

	public static void main(String[] args) throws Exception {
		MyIn1 myIn1 = new MyIn1("hans");
		
		MyIn2 myIn2 = new MyIn2("raj");
		

	}

}
