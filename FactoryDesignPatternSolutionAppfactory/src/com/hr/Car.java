package com.hr;

public class Car {
 
	private Engine engine;
	
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}


	public void createCar() {
		String car = null;
		car = engine.createEngine("engine is installed");
		System.out.println(car);
	}
}
