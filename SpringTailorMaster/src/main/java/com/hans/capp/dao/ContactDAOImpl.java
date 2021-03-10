package com.hans.capp.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.hans.capp.domain.Contact;
import com.hans.capp.rm.ContactRowMapper;

@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO{

	
	public void save(Contact c) {
		String sql = "INSERT INTO contact (userId, name, phone, email, address, remark) "
				+ "VALUES (:userId, :name, :phone, :email, :address, :remark)";
	
			
			
			Map m = new HashMap();
			m.put("userId", c.getUserId());
			m.put("name", c.getName());
			m.put("phone", c.getPhone());
			m.put("email", c.getEmail());
			m.put("address", c.getAddress());
			m.put("remark", c.getRemark());
			
		
			
			SqlParameterSource ps = new MapSqlParameterSource(m);
			KeyHolder kh = new GeneratedKeyHolder();
			getNamedParameterJdbcTemplate().update(sql, ps, kh);
			Integer contactId = kh.getKey().intValue();
			c.setContactId(contactId);
		
		
		
		
	}

	public void update(Contact c) {
		String sql = "UPDATE contact SET "
				+ "name=:name, "
				+ "phone=:phone, "
				+ "email=:email, "
				+ "address=:address, "
				+ "remark=:remark "
				+ "WHERE contactId=:contactId";
		Map m = new HashMap();
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		m.put("contactId", c.getContactId());
		
		SqlParameterSource ps = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, ps);
		
	}

	public void delete(Contact c) {
		this.delete(c.getContactId());
		
	}

	public void delete(Integer contactId) {
		String sql = "DELETE FROM contact WHERE contactid = ?";
		getJdbcTemplate().update(sql, contactId);
		
	}

	public Contact findById(Integer contactId) {
		String sql = "SELECT userid, contactid, name, phone, email, address, remark "
				+ "FROM contact WHERE contactid = ?";
		
		return  getJdbcTemplate().queryForObject(sql,new ContactRowMapper(),contactId);
	}

	public List<Contact> findAll() {
		String sql = "SELECT userid, contactid, name, phone, email, address, remark "
				+ "FROM contact";
		return getJdbcTemplate().query(sql, new ContactRowMapper());
	}

	public List<Contact> findByProperty(String propName, Object propValue) {
		String sql = "SELECT userid, contactid, name, phone, email, address, remark "
				+ "FROM contact WHERE "
				+ propName +" = ? ";
		return getJdbcTemplate().query(sql, new ContactRowMapper(), propValue);
		
		
	}

	
}
