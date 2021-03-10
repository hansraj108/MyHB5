package com.hr;

public class Sensor {

	private int id;
	private String range;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	@Override
	public String toString() {
		return "Sensor [id=" + id + ", range=" + range + "]";
	}
	
	
}
