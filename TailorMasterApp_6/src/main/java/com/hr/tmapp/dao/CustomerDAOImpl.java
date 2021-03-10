package com.hr.tmapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.hr.tmapp.domain.Customer;
import com.hr.tmapp.rm.CustomerRowMapper;

@Repository
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {

	
	@Override
	public void save(Customer customer) {
		String sql = "INSERT INTO customers (userId, measurementId, firstName, lastName, phone, email, address, remark) "
				+ "VALUES (:userId, :measurementId, :firstName, :lastName, :phone, :email, :address, :remark)";
	
			
			
			Map m = new HashMap();
			m.put("userId", customer.getUserId());
			m.put("measurementId", customer.getMeasurementId());
			m.put("firstName", customer.getFirstName());
			m.put("lastName", customer.getLastName());
			m.put("phone", customer.getPhone());
			m.put("email", customer.getEmail());
			m.put("address", customer.getAddress());
			m.put("remark", customer.getRemark());
			
		
			
			SqlParameterSource ps = new MapSqlParameterSource(m);
			KeyHolder kh = new GeneratedKeyHolder();
			getNamedParameterJdbcTemplate().update(sql, ps, kh);
			Integer customerId = kh.getKey().intValue();
			customer.setCustomerId(customerId);
		
	}

	@Override
	public void update(Customer customer) {
		String sql = "UPDATE customers SET "
				+ "firstName=:firstName, "
				+ "lastName = :lastName, "
				+ "phone=:phone, "
				+ "email=:email, "
				+ "address=:address, "
				+ "remark=:remark "
				+ "WHERE customerId=:customerId";
		Map m = new HashMap();
		m.put("firstName", customer.getFirstName());
		m.put("lastName", customer.getLastName());
		m.put("phone", customer.getPhone());
		m.put("email", customer.getEmail());
		m.put("address", customer.getAddress());
		m.put("remark", customer.getRemark());
		m.put("customerId", customer.getCustomerId());
		
		SqlParameterSource ps = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, ps);
		
	}

	@Override
	public void delete(Customer customer) {
		this.delete(customer.getCustomerId());
		
	}

	@Override
	public void delete(Integer customerId) {
		String sql = "DELETE FROM customers WHERE CustomerId = ?";
		getJdbcTemplate().update(sql, customerId);
		
	}

	@Override
	public Customer findById(Integer customerId) {
		String sql = "SELECT userId, customerId, measurementId, firstName, lastName, phone, email, address, remark "
				+ "FROM customers WHERE CustomerId = ?";
		
		return  getJdbcTemplate().queryForObject(sql,new CustomerRowMapper(),customerId);
	}

	@Override
	public List<Customer> findAll() {
		String sql = "SELECT userId, measurementId, firstName, lastName, phone, email, address, remark "
				+ "FROM customers";
		
		return  getJdbcTemplate().query(sql,new CustomerRowMapper());
	}

	@Override
	public List<Customer> findByProperty(String propName, Object propValue) {
		String sql = "SELECT userId, customerID, measurementId, firstName, lastName, phone, email, address, remark "
				+ "FROM customers WHERE "
				+ propName +" = ? ";
			//	+ "ORDER BY CustomerID DESC";
		
		return  getJdbcTemplate().query(sql,new CustomerRowMapper(),propValue);
	}
	
}

