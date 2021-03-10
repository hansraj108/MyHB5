package com.hans.capp.controller;

import java.util.List;

public class Employee {

	
	private boolean visaApproved = true;
	 
	private List<String> languagesKnown;
 
	private List<String> hobbies;
 
	private List<String> socialProfiles;

	public boolean isVisaApproved() {
		return visaApproved;
	}

	public void setVisaApproved(boolean visaApproved) {
		this.visaApproved = visaApproved;
	}

	public List<String> getLanguagesKnown() {
		return languagesKnown;
	}

	public void setLanguagesKnown(List<String> languagesKnown) {
		this.languagesKnown = languagesKnown;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public List<String> getSocialProfiles() {
		return socialProfiles;
	}

	public void setSocialProfiles(List<String> socialProfiles) {
		this.socialProfiles = socialProfiles;
	}
	
	
	
}
