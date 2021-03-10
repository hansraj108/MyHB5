package com.hans.capp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hans.capp.domain.Contact;

public class ContactRowMapper implements RowMapper<Contact> {

	public Contact mapRow(ResultSet rs, int i) throws SQLException {
		Contact c = new Contact();
		c.setUserId(rs.getInt("userId"));
		c.setName(rs.getString("name"));
		c.setPhone(rs.getString("phone"));
		c.setEmail(rs.getString("email"));
		c.setAddress(rs.getString("address"));
		c.setContactId(rs.getInt("contactId"));
		c.setRemark(rs.getString("remark"));
		return c;
	}

}
