package com.hr;

public class CarTest {

	public static void main(String[] args) {
	
	Car car = new Car();
//	Engine engine = new V8Engine();
	Engine engine = new V12Engine();
	car.setEngine(engine);
	car.createCar();
}
}