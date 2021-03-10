package com.hr;

public class EngineProducerFactory {

	public static Engine produceEngine(String type) {
		Engine engine = null;
	
		if(type.equals("hyundai")) {
			engine = new V12Engine();
		}
		else if(type.equals("honda")) {
			engine = new V8Engine();
		}
		return engine;
	}
}
