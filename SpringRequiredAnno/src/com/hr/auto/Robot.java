package com.hr.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Robot {

	
	private Chip chip;
	private Sensor sensor;
	
@Autowired(required = false)
		public Robot(Sensor sensor) {
		super();
		this.sensor = sensor;
	}

	@Autowired(required = false)
	public Robot(Chip chip) {
		super();
		this.chip = chip;
	}

	
	@Autowired(required = true)
	public Robot(Chip chip, Sensor sensor) {
		super();
		this.chip = chip;
		this.sensor = sensor;
	}

	@Override
	public String toString() {
		
		return "Robot [CHIP= "+chip +", SENSOR= "+sensor +"]";
		
	}
	
	
}
