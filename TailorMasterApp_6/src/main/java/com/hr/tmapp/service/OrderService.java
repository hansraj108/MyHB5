package com.hr.tmapp.service;

import java.util.List;

import com.hr.tmapp.domain.FileBucket;
import com.hr.tmapp.domain.Measurement;
import com.hr.tmapp.domain.Order;

public interface OrderService {

	public static final Integer ORDER_STATUS_PENDING = 1; //
	public static final Integer ORDER_STATUS_ONGOING = 2; //
	public static final Integer ORDER_STATUS_COMPLETE = 3; //
	public static final Integer ORDER_STATUS_DELIVERED = 4; //
	
	public void save(Order order);
	
	public List<Order> ordersByCustomerId(Integer customerId);

	public List<Order> findAllPhotoByOrderId(Integer orderId);
        
        public List<Order> allOrders();

	public void saveFileBucket(FileBucket fb);

	public List<FileBucket> findAllFileBucketByCustomerId(Integer customerId);

	public List<FileBucket> findAllFileBucketByOrderId(Integer orderId);

	public void updateOrderIdInPhotos(Integer orderId, Integer[] photoIds);

	public void updateOrderIdInPhotos(Integer orderId, Integer photoIds);

	public void changeOrderStatus(Integer orderId, Integer orderStatus);

        public List<Order> searchOrders(Integer customerId, String freeText);

        public void deleteAll(Integer[] orderIds);

        public void deleteOrder(Integer orderId);

        public FileBucket findByPhotoId(Integer photoId);

		public void deleteFile(Integer photoId);

		public void deleteSelectedPhotots(Integer[] photoIds);
	
	
	
}
