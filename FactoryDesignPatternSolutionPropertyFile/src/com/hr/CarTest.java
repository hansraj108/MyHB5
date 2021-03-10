package com.hr;

import java.io.FileInputStream;
import java.io.IOException;

public class CarTest {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
	
	Car car = new Car();
//	Engine engine = new V8Engine();
	
	FileInputStream fis = new FileInputStream("src/abc.txt");
	byte[] bs = new byte[40];
	fis.read(bs);
	String className = new String(bs).trim();
	Engine engine = (Engine) Class.forName(className).newInstance();
	car.setEngine(engine);
	car.createCar();
}
}