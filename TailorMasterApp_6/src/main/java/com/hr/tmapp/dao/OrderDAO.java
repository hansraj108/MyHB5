package com.hr.tmapp.dao;

import java.util.List;

import com.hr.tmapp.domain.FileBucket;
import com.hr.tmapp.domain.Measurement;
import com.hr.tmapp.domain.Order;

public interface OrderDAO {

	public void save(Order order);

	public void update(Order order);

	public void deleteByOrderId(Integer orderId);

	public List<Order> findByOrderId(Integer orderId);

	public List<Order> findByMeasurementId(Integer measurementId);

	public List<Order> findByCustomerId(Integer customerId);

	public List<Order> findAll();

	public List<Order> findByProperty(String propName, Object PropValue);

	public void saveFileBucket(FileBucket fb);

	public List<FileBucket> findAllFileBucket(Integer customerId);

	public List<FileBucket> findByPropertyFileBucket(String propName, Object PropValue);

        public List<Order> findAllOrderByUser();

        public FileBucket findByPhotoId(Integer photoId);

		public void deleteFile(Integer photoId);
}
