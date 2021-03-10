package com.hr.tmapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.hr.tmapp.domain.FileBucket;
import com.hr.tmapp.domain.Order;
import com.hr.tmapp.rm.FileBucketRowMapper;
import com.hr.tmapp.rm.OrderRowMapper;

@Repository
public class OrderDAOImpl extends BaseDAO implements OrderDAO {

	@Override
	public void save(Order order) {
		String sql = "INSERT INTO orders (CustomerID, MeasurementID, OrderName, Quantity, TotalPrice, Color, OrderStatus, OrderDate, DeliveryDate, BillDate, Remark ) "
				+ "VALUES (:customerId, :measurementId, :orderName, :quantity, :totalPrice, :color, :orderStatus, :orderDate, :deliveryDate, :billDate, :remark)";
		Map m = new HashMap();
		m.put("customerId",order.getCustomerId());
		m.put("measurementId",order.getMeasurementId());
		m.put("orderName",order.getOrderName());
		m.put("quantity",order.getQuantity());
		m.put("totalPrice",order.getTotalPrice());
		m.put("color",order.getColor());
		m.put("orderStatus",order.getOrderStatus());
		m.put("orderDate",order.getOrderDate());
		m.put("deliveryDate",order.getDeliveryDate());
		m.put("billDate",order.getBillDate());
		m.put("remark",order.getRemark());
		m.put("description",order.getDescription());
		
		
		SqlParameterSource ps = new MapSqlParameterSource(m);
		KeyHolder kh = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		Integer orderId = kh.getKey().intValue();
		order.setOrderId(orderId);
		
		
	}

	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByOrderId(Integer orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> findByOrderId(Integer orderId) {
		String sql = "SELECT OrderID, CustomerID, MeasurementID, OrderName, Quantity, TotalPrice, Color, OrderStatus, OrderDate, DeliveryDate, BillDate, Remark, "
				+ "Name, Description, Type, Content "
				+ "FROM orders WHERE OrderID = ?";
		return getJdbcTemplate().query(sql, new OrderRowMapper(), orderId);
	}

	@Override
	public List<Order> findByMeasurementId(Integer measurementId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByCustomerId(Integer customerId) {
		String sql = "SELECT OrderID, CustomerID, MeasurementID, OrderName, Quantity, TotalPrice, Color, OrderStatus, OrderDate, DeliveryDate, BillDate, Remark, "
				+ "Name, Description, Type, Content "
				+ "FROM orders WHERE CustomerID = ? "
				+ "ORDER BY OrderDate DESC";
				
			return getJdbcTemplate().query(sql, new OrderRowMapper(), customerId);
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByProperty(String propName, Object PropValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveFileBucket(FileBucket fb) {
		String sql = "INSERT INTO fileBucket (PhotoID, OrderID, CustomerID, MeasurementID, Name, Type, Content, Description, SaveDate) "
				+ "VALUES (:photoId, :orderId, :customerId, :measurementId, :name, :type, :content, :description, :saveDate )";
		Map m = new HashMap();
		m.put("photoId", fb.getPhotoId());
		m.put("orderId", fb.getOrderId());
		m.put("customerId", fb.getCustomerId());
		m.put("name", fb.getName());
		m.put("type", fb.getType());
		m.put("content", fb.getContent());
		m.put("description", fb.getDescription());
		m.put("saveDate", fb.getSaveDate());
		m.put("measurementId", fb.getMeasurementId());
		
		SqlParameterSource ps = new MapSqlParameterSource(m);
		KeyHolder kh = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		Integer photoId = kh.getKey().intValue();
		fb.setPhotoId(photoId);
	}

	@Override
	public List<FileBucket> findAllFileBucket(Integer customerId) {
		String sql = "SELECT PhotoID, OrderID, CustomerID, MeasurementID, Name, Type, Content, Description, SaveDate "
				+ " FROM fileBucket "
				+ "WHERE CustomerID = ? "
				+ " ORDER BY SaveDate DESC";
		
		 return getJdbcTemplate().query(sql, new FileBucketRowMapper(), customerId);
	}
	
	@Override
	public List<FileBucket> findByPropertyFileBucket(String propName, Object PropValue) {
		String sql = "SELECT PhotoID, OrderID, CustomerID, MeasurementID, Name, Type, Content, Description, SaveDate "
				+ " FROM fileBucket "
				+ " WHERE "+propName+
				" = ? ORDER BY PhotoID DESC";
		return getJdbcTemplate().query(sql, new FileBucketRowMapper(), PropValue);
		
	}

    @Override
    public List<Order> findAllOrderByUser() {
        
        String sql = "SELECT OrderID, CustomerID, MeasurementID, OrderName, Quantity, TotalPrice, Color, OrderStatus, OrderDate, DeliveryDate, BillDate, Remark, "
				+ "Name, Description, Type, Content "
				+ "FROM orders ORDER BY OrderID desc"; 
		return getJdbcTemplate().query(sql, new OrderRowMapper());
    }

    @Override
    public FileBucket findByPhotoId(Integer photoId) {
        String sql = "SELECT PhotoID, OrderID, CustomerID, MeasurementID, Name, Type, Content, Description, SaveDate "
				+ " FROM fileBucket "
				+ " WHERE PhotoID = "
                                + photoId;
				
		return getJdbcTemplate().queryForObject(sql, new FileBucketRowMapper());
    }

	@Override
	public void deleteFile(Integer photoId) {
		String sql = "DELETE FROM filebucket WHERE PhotoID = ?";
		getJdbcTemplate().update(sql,photoId);
		
	}

}
