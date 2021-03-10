package com.nt.beans;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class CheckboxBean {

	@NotEmpty
	private List favourite;

	
	public List getFavourite() {
		return favourite;
	}

	public void setFavourite(List favourite) {
		this.favourite = favourite;
	}
}
