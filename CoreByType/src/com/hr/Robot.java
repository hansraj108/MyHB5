package com.hr;

public class Robot {
	
	private Chip chip;
	private Sensor sensor;
	public Chip getChip() {
		return chip;
	}
	public void setChip(Chip chip) {
		this.chip = chip;
	}
	public Sensor getSensor() {
		return sensor;
	}
	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
	@Override
	public String toString() {
		return "Robot [chip=" + chip + ", sensor=" + sensor + "]";
	}
	
	

}
