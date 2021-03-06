package com.hans.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.hans.capp.domain.Contact;
import com.hans.capp.rm.ContactRowMapper;

@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

	@Override
	public void save(Contact contact) {
		String sql = "INSERT INTO contact (userId, name, phone, email, address, remark)"
				+ "VALUES (:userId, :name, :phone, :email, :address, :remark)";
		Map map = new HashMap();
		map.put("userId",contact.getUserId());
		map.put("name",contact.getName());
		map.put("phone",contact.getPhone());
		map.put("email",contact.getEmail());
		map.put("address",contact.getAddress());
		map.put("remark",contact.getRemark());
		
		SqlParameterSource ps = new MapSqlParameterSource(map);
		KeyHolder kh = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		
		contact.setContactId(kh.getKey().intValue());
	}

	@Override
	public void update(Contact contact) {
		String sql = "UPDATE contact SET "
				+ "name=:name,"
				+ "phone=:phone,"
				+ "email=:email,"
				+ "address=:address,"
				+ "remark=:remark "
				+ "WHERE contactId=:contactId";
		
		Map map = new HashMap();
		map.put("name", contact.getName());
		map.put("phone", contact.getPhone());
		map.put("email", contact.getEmail());
		map.put("address", contact.getAddress());
		map.put("remark", contact.getRemark());
		map.put("contactId", contact.getContactId());
		
		SqlParameterSource ps= new MapSqlParameterSource(map);
		getNamedParameterJdbcTemplate().update(sql, ps);
		
				
		
	}

	@Override
	public void delete(Contact contact) {
		this.delete(contact.getContactId());
		
	}

	@Override
	public void delete(Integer contactId) {
		String sql = "DELETE FROM contact WHERE contactId = ?";
		getJdbcTemplate().update(sql, contactId);
		
	}

	@Override
	public Contact findById(Integer contactId) {
		String sql = "SELECT contactId, userId, name, phone, email, address, remark "
				+ "FROM contact WHERE contactId=?";
		
		Contact c=  getJdbcTemplate().queryForObject(sql,new ContactRowMapper(), contactId);
		return c;
	}

	@Override
	public List<Contact> findAll() {
		String sql = "SELECT contactId, userId, name, phone, email, address, remark "
				+ "FROM contact";
		return getJdbcTemplate().query(sql, new ContactRowMapper());
		 
	}

	@Override
	public List<Contact> findByProperty(String propName, Object propValue) {
		String sql = "SELECT contactId, userId, name, phone, email, address, remark "
				+ "FROM contact WHERE "+propName+ "=?";
		return getJdbcTemplate().query(sql, new ContactRowMapper(),propValue);
	}

	
}
