package com.hr;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CarTest {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
	
	Car car = (Car) AppFactory.createObject("car.class");
//	Engine engine = new V8Engine();
	Engine engine = (Engine) AppFactory.createObject("engine.class");
	car.setEngine(engine);
	car.createCar();
}
}