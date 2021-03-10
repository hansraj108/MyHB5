package com.hr.tmapp.domain;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Order {

	private Integer orderId;
	private Integer customerId;
	private Integer measurementId;
	private String orderName;
	private Integer quantity;
	private Double totalPrice;
	private String color;
	private Integer orderStatus;
	private Date orderDate;
	private Date deliveryDate;
	private Date billDate;
	private String remark;
	
	private List<MultipartFile> photos;
	private String description;
	private List<FileBucket> fileBucket;
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Order(Integer orderId, Integer customerId, Integer measurementId, String orderName, Integer quantity,
			Double totalPrice, String color, Integer orderStatus, Date orderDate, Date deliveryDate, Date billDate,
			String remark, List<MultipartFile> photos, String description, List<FileBucket> fileBucket) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.measurementId = measurementId;
		this.orderName = orderName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.color = color;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.billDate = billDate;
		this.remark = remark;
		this.photos = photos;
		this.description = description;
		this.fileBucket = fileBucket;
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


	public String getOrderName() {
		return orderName;
	}


	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public Integer getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public Date getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public Date getBillDate() {
		return billDate;
	}


	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public List<MultipartFile> getPhotos() {
		return photos;
	}


	public void setPhotos(List<MultipartFile> photos) {
		this.photos = photos;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<FileBucket> getFileBucket() {
		return fileBucket;
	}


	public void setFileBucket(List<FileBucket> fileBucket) {
		this.fileBucket = fileBucket;
	}


	
}
