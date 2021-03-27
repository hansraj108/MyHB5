package com.nt.resource;

public class NumbersGenerator {

	private int number=1;
	private int numberOfThreads;
	private int totalNumbersInSequence;
	
	public NumbersGenerator(int numberOfThreads, int totalNumbersInSequence) {
		super();
		this.numberOfThreads = numberOfThreads;
		this.totalNumbersInSequence = totalNumbersInSequence;
	}
	
	public void printNumbers(int result) {
		synchronized (this) {
			while (number < totalNumbersInSequence-1) {
				while (number != numberOfThreads) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName()+" "+number++);
				notifyAll();
			}
		}
	}
	
}
