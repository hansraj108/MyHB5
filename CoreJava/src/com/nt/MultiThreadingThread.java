package com.nt;

class Hi extends Thread{
	public void run() {
		for (int i=0; i<=5; i++) {
		System.out.println("hi");
		try {
			Thread.sleep(500);
			 }catch(Exception e) {
				 
			 }
		}
	}
}

class Hello extends Thread{
	public void run() {
		for (int i=0; i<=5; i++) {
		System.out.println("hello");
		}
	}
}
public class MultiThreadingThread {
 public static void main(String[] args) {
	
	 Hi hi = new Hi();
	 Hello hello = new Hello();
	 
	 hi.start();
	 try {
			Thread.sleep(10);
			 }catch(Exception e) {
				 
			 }
	 hello.start();
}
}
