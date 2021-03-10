package com.hr;

public class V8Engine implements Engine {

	@Override
	public String createEngine(String type) {
		
		return "V8 "+type;
	}
}
