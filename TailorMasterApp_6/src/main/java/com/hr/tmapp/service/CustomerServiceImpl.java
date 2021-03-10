package com.hr.tmapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.tmapp.dao.BaseDAO;
import com.hr.tmapp.dao.CustomerDAO;
import com.hr.tmapp.domain.Customer;
import com.hr.tmapp.rm.CustomerRowMapper;
import com.hr.tmapp.util.StringUtil;

@Service
public class CustomerServiceImpl extends BaseDAO implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	public void save(Customer c) {
		customerDAO.save(c);
		
	}

	@Override
	public void update(Customer c) {
		customerDAO.update(c);
		
	}

	@Override
	public void delete(Integer customerId) {
		customerDAO.delete(customerId);
		
	}

	@Override
	public void deleteAll(Integer[] customerIds) {
		String ids = StringUtil.toCommaSeperatedString(customerIds);
		String sql = "DELETE FROM customers WHERE CustomerID IN ("+ids+") ";
		getJdbcTemplate().update(sql);
		
	}

	@Override
	public List<Customer> findUserCustomer(Integer userId) {
		return customerDAO.findByProperty("userId", userId);
	}

	@Override
	public List<Customer> findUserCustomer(Integer userId, String text) {
		
		String sql = "SELECT userId, customerId, measurementId, firstName, lastName, phone, email, address, remark "
				+ "FROM customers WHERE UserID = ? AND (customerId LIKE '%"+text+"%' OR measurementId LIKE '%"+text+"%' OR firstName LIKE '%"+text+"%' OR lastName LIKE '%"+text+"%' OR phone LIKE '%"+text+"%' OR email LIKE '%"+text+"%' OR address LIKE '%"+text+"%' OR remark LIKE '%"+text+"%')";

		return getJdbcTemplate().query(sql, new CustomerRowMapper(), userId);
		
	}

	@Override
	public Customer findById(Integer customerId) {
		return customerDAO.findById(customerId);
	}

}
