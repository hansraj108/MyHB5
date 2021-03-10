package com.hr;

public class Robot {
	
	private Chip chip;
	private Sensor sensor;
	
	public Robot(Sensor sensor) {
		super();
		this.sensor = sensor;
	}
	public Robot(Chip chip) {
		super();
		this.chip = chip;
	}
	

	/*
	 * public Robot(Chip chip, Sensor sensor2) { super(); this.chip = chip;
	 * this.sensor = sensor2; }
	 */
	@Override
	public String toString() {
		return "Robot [chip=" + chip + ", sensor=" + sensor + "]";
	}
	
	

}
