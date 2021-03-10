package com.hr;

public class Child {
	
	private Parent parent;

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Child [parent=" + parent + "]";
	}
	
	

}
