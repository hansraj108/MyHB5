package com.hr.TeluskoHB1;

import javax.persistence.Embeddable;

@Embeddable
public class AlienName {

	private String fName;
	private String lName;
	private String sName;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	@Override
	public String toString() {
		return "AlienName [fName=" + fName + ", lName=" + lName + ", sName=" + sName + "]";
	}
	
	
}
