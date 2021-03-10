package com.hr;

import java.util.List;

public class Course {

	private List<String> subjects;

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Course [subjects=" + subjects + "]";
	}
	
	
}
