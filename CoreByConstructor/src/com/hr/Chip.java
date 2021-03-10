package com.hr;

public class Chip {

	private int id;
	private String type;
	
	
	public Chip(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}


	@Override
	public String toString() {
		return "Chip [id=" + id + ", type=" + type + "]";
	}
	
	
	
}
