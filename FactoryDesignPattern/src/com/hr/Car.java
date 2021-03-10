package com.hr;

public class Car {
 
	private Engine engine;
	
	public void createCar() {
		String car = null;
		engine = EngineProducerFactory.produceEngine("hyundai");
		car = engine.createEngine("engine is installed");
		System.out.println(car);
	}
}
