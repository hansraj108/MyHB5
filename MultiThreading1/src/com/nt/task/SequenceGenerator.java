package com.nt.task;

import com.nt.resource.NumbersGenerator;

public class SequenceGenerator implements Runnable{

	private NumbersGenerator numbersGenerator;
	private int result;
	
	
	public SequenceGenerator(NumbersGenerator numbersGenerator, int result) {
		super();
		this.numbersGenerator = numbersGenerator;
		this.result = result;
	}


	@Override
	public void run() {
		numbersGenerator.printNumbers(result);
		
	}

}
