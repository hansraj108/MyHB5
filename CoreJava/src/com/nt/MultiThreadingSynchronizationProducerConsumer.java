package com.nt;

class P{
	int num;
	boolean valueSet = false;
	
	public synchronized void put(int num) {
		while(valueSet) {
			try { wait(); } catch(Exception e) {}
		}
		System.out.println("PUT: "+num);
		this.num = num;
		valueSet = true;
		notify();
	}
	public synchronized void get() {
		while(!valueSet) {
			try { wait(); } catch(Exception e) {}
		}
		System.out.println("GET: "+num);
		valueSet = false;
		notify();
	}
}

class Producer1 implements Runnable{
	
	P p;

	public Producer1(P p) {
		this.p = p;
		Thread t = new Thread(this,"Producer1");
		t.start();
		}

	@Override
	public void run() {
		int i = 0;
		while(true) {
			p.put(i++);
			try { Thread.sleep(1000);}catch(Exception e) {}
		}
		
	}
		
}

class Consumer1 implements Runnable{
	
	P p;

	public Consumer1(P p) {
		this.p = p;
		Thread t = new Thread(this,"Consumer1");
		t.start();
	}

	@Override
	public void run() {
		while(true) {
			p.get();
			try { Thread.sleep(1000);}catch(Exception e) {}
		}
	}
	
	
	
}


public class MultiThreadingSynchronizationProducerConsumer {

	public static void main(String[] args) {
		P p = new P();
		new Producer1(p);
		new Consumer1(p);
	}
}
