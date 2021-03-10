package com.hr.tmapp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hr.tmapp.domain.Customer;

public class CustomerRowMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer c = new Customer();
		c.setUserId(rs.getInt("UserID"));
		c.setCustomerId(rs.getInt("customerID"));
		c.setMeasurementId(rs.getInt("MeasurementID"));
		c.setFirstName(rs.getString("FirstName"));
		c.setLastName(rs.getString("LastName"));
		c.setPhone(rs.getString("Phone"));
		c.setEmail(rs.getString("Email"));
		c.setAddress(rs.getString("Address"));
		c.setRemark(rs.getString("Remark"));
		return c;
	}

}
