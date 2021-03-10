package com.hr.tmapp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hr.tmapp.domain.Order;

public class OrderRowMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Order o = new Order();
		o.setOrderId(rs.getInt("OrderID"));
		o.setCustomerId(rs.getInt("CustomerID"));
		o.setMeasurementId(rs.getInt("MeasurementID"));
		o.setOrderName(rs.getString("OrderName"));
		o.setQuantity(rs.getInt("Quantity"));
		o.setTotalPrice(rs.getDouble("TotalPrice"));
		o.setColor(rs.getString("Color"));
		o.setOrderStatus(rs.getInt("OrderStatus"));
		o.setOrderDate(rs.getDate("OrderDate"));
		o.setDeliveryDate(rs.getDate("DeliveryDate"));
		o.setBillDate(rs.getDate("BillDate"));
		o.setRemark(rs.getString("Remark"));
		o.setDescription(rs.getString("Description"));
		
		
		
		
		return o;
	}

}
