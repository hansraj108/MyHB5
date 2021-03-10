package com.hr.tmapp.domain;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Measurement {

	
	private Integer measurementId;	//pk
	private Integer userId; //fk
	private Integer customerId;	//fk
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date lastUpdate;
	private String shirtLength;
	private String armLength;
	private String neck;
	private String chest;
	private String waist;
	public String remark;
	
	
	public Measurement() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Measurement(Integer measurementId, Integer userId, Integer customerId, Date lastUpdate, String shirtLength,
			String armLength, String neck, String chest, String waist, String remark) {
		super();
		this.measurementId = measurementId;
		this.userId = userId;
		this.customerId = customerId;
		this.lastUpdate = lastUpdate;
		this.shirtLength = shirtLength;
		this.armLength = armLength;
		this.neck = neck;
		this.chest = chest;
		this.waist = waist;
		this.remark = remark;
	}



	public Integer getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(Integer measurementId) {
		this.measurementId = measurementId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getShirtLength() {
		return shirtLength;
	}

	public void setShirtLength(String shirtLength) {
		this.shirtLength = shirtLength;
	}

	public String getArmLength() {
		return armLength;
	}

	public void setArmLength(String armLength) {
		this.armLength = armLength;
	}

	public String getNeck() {
		return neck;
	}

	public void setNeck(String neck) {
		this.neck = neck;
	}

	public String getChest() {
		return chest;
	}

	public void setChest(String chest) {
		this.chest = chest;
	}

	public String getWaist() {
		return waist;
	}

	public void setWaist(String waist) {
		this.waist = waist;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}

	
}
