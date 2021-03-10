package com.hr.TeluskoHB1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Laptop {

	@Id
	private int lId;
	private String lName;
	@ManyToMany (mappedBy = "laptop")
	private List<Student> student;
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	
	
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Laptop [lId=" + lId + ", lName=" + lName + ", student=" + student + "]";
	}
	
	
}
