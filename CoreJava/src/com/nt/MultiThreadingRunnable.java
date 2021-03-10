package com.nt;

class Hii implements Runnable{
	public void run() {
		for (int i=0; i<=5; i++) {
		System.out.println("hii");
		try {
			Thread.sleep(500);
			 }catch(Exception e) {
				 
			 }
		}
	}
}

class Helloo implements Runnable{
	public void run() {
		for (int i=0; i<=5; i++) {
		System.out.println("helloo");
		}
	}
}
public class MultiThreadingRunnable {

public static void main(String[] args) {
	

	Runnable hii = new Hii();
	Runnable helloo = new Helloo();
	
	Thread t1 = new Thread(hii);
	Thread t2 = new Thread(helloo);
	
	t1.start();
	t2.start();

	
}	
}
