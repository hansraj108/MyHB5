package com.hr.tmapp.domain;

import java.util.Date;

public class FileBucket {

	private Integer photoId;	//pk
	private Integer orderId;	//fk
	private Integer customerId; //fk
	private Integer measurementId; //fk
	private String name;
	private String type;
	private byte[] content;
	private String description;
	private Date saveDate;
	
	
	
	public FileBucket() {
		super();
		// TODO Auto-generated constructor stub
	}



	public FileBucket(Integer photoId, Integer orderId, Integer customerId, Integer measurementId, String name,
			String type, byte[] content, String description, Date saveDate) {
		super();
		this.photoId = photoId;
		this.orderId = orderId;
		this.customerId = customerId;
		this.measurementId = measurementId;
		this.name = name;
		this.type = type;
		this.content = content;
		this.description = description;
		this.saveDate = saveDate;
	}



	public Integer getPhotoId() {
		return photoId;
	}



	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}



	public Integer getOrderId() {
		return orderId;
	}



	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}



	public Integer getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}



	public Integer getMeasurementId() {
		return measurementId;
	}



	public void setMeasurementId(Integer measurementId) {
		this.measurementId = measurementId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public byte[] getContent() {
		return content;
	}



	public void setContent(byte[] content) {
		this.content = content;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Date getSaveDate() {
		return saveDate;
	}



	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}



	
}
