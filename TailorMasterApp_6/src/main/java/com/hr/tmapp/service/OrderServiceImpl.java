package com.hr.tmapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.hr.tmapp.dao.BaseDAO;
import com.hr.tmapp.dao.OrderDAO;
import com.hr.tmapp.domain.FileBucket;
import com.hr.tmapp.domain.Measurement;
import com.hr.tmapp.domain.Order;
import com.hr.tmapp.rm.MeasurementRowMapper;
import com.hr.tmapp.rm.OrderRowMapper;
import com.hr.tmapp.util.StringUtil;

@Service
public class OrderServiceImpl extends BaseDAO implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public void save(Order order) {
		order.setOrderStatus(ORDER_STATUS_PENDING);
		orderDAO.save(order);
		
	}

	@Override
	public List<Order> ordersByCustomerId(Integer customerId) {
		
		return orderDAO.findByCustomerId(customerId);
	}

	@Override
	public List<Order> findAllPhotoByOrderId(Integer orderId) {

		return orderDAO.findByOrderId(orderId);
	}

	@Override
	public void saveFileBucket(FileBucket fb) {
		orderDAO.saveFileBucket(fb);
		
	}

	@Override
	public List<FileBucket> findAllFileBucketByCustomerId(Integer customerId) {
		
		//return orderDAO.findAllFileBucket(customerId);
		return orderDAO.findByPropertyFileBucket("customerId", customerId);
	}

	@Override
	public List<FileBucket> findAllFileBucketByOrderId(Integer orderId) {
		
		//return orderDAO.findAllFileBucket(customerId);
		return orderDAO.findByPropertyFileBucket("OrderId", orderId);
	}

	@Override
	public void updateOrderIdInPhotos(Integer orderId, Integer[] photoIds) {
		String ids = StringUtil.toCommaSeperatedString(photoIds);
		String sql = "INSERT INTO filebucket (OrderID) VALUES (:orderId) "
				+ "WHERE PhotoID IN ("+ids+") ";
		Map m = new HashMap();
		m.put("orderId",orderId);
		SqlParameterSource ps = new MapSqlParameterSource(m);
		
		getNamedParameterJdbcTemplate().update(sql, ps);
		
	}

	@Override
	public void updateOrderIdInPhotos(Integer orderId, Integer photoId) {
		String sql = "update   filebucket SET OrderID= :orderId WHERE PhotoID = :photoId ";
				
		Map m = new HashMap();
		m.put("orderId",orderId);
		m.put("photoId",photoId);
		SqlParameterSource ps = new MapSqlParameterSource(m);
		
		getNamedParameterJdbcTemplate().update(sql, ps);
		
	}
	
	public void changeOrderStatus(Integer orderId, Integer orderStatus) {
		String sql = "UPDATE orders SET OrderStatus = :orderStatus WHERE OrderID = :orderId";
		System.out.println("===================> +++++++++++++++++++++++changeOrderStatus");
		Map m = new HashMap();
		m.put("orderStatus", orderStatus);
		m.put("orderId", orderId);
		SqlParameterSource ps = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, ps);
		
	}

    @Override
    public List<Order> searchOrders(Integer customerId, String text) {
        String sql = "SELECT OrderID, CustomerID, MeasurementID, OrderName, Quantity, TotalPrice, Color, OrderStatus, "
                + " OrderDate, DeliveryDate, BillDate, Remark, Name, Description, Type, Content "
		+ "FROM orders WHERE customerId=? AND (OrderID LIKE '%"+text+"%' OR CustomerID LIKE '%"+text+"%' OR MeasurementID LIKE '%"+text+"%' OR OrderName LIKE '%"+text+"%' OR OrderDate LIKE '%"+text+"%' OR Remark LIKE '%"+text+"%' OR Name LIKE '%"+text+"%'  OR Color LIKE '%"+text+"%')";
		return getJdbcTemplate().query(sql, new OrderRowMapper(), customerId);
	}

    @Override
    public List<Order> allOrders() {
       return orderDAO.findAllOrderByUser();
    }

    @Override
    public void deleteAll(Integer[] orderIds) {
        String ids = StringUtil.toCommaSeperatedString(orderIds);
        String sql = "DELETE FROM orders WHERE OrderId IN ("+ids+") ";
		getJdbcTemplate().update(sql);
    }
    
    @Override
    public void deleteOrder(Integer orderId){
        String sql = "DELETE FROM orders WHERE OrderId = "+orderId;
		getJdbcTemplate().update(sql);
    }
    
    @Override
    public FileBucket findByPhotoId(Integer photoId){
        return orderDAO.findByPhotoId(photoId);
    }

	@Override
	public void deleteFile(Integer photoId) {
		orderDAO.deleteFile(photoId);
		
	}

	@Override
	public void deleteSelectedPhotots(Integer[] photoIds) {
		String ids = StringUtil.toCommaSeperatedString(photoIds);
        String sql = "DELETE FROM filebucket WHERE PhotoId IN ("+ids+") ";
		getJdbcTemplate().update(sql);
		
	}
    }
	

