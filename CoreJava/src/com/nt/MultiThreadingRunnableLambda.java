package com.nt;


public class MultiThreadingRunnableLambda {

public static void main(String[] args) {
	

	
	
	Thread t1 = new Thread(() -> {
		for (int i=0; i<=5; i++) {
		System.out.println("hii");
		try {
			Thread.sleep(500);
			 }catch(Exception e) {
				 
			 }
		}
	});
	Thread t2 = new Thread(() -> {
		for (int i=0; i<=5; i++) {
		System.out.println("helloo");
		}
	});
	
	t1.start();
	t2.start();

	
}	
}
