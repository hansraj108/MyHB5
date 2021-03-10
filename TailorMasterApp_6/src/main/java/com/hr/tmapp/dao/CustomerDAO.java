package com.hr.tmapp.dao;

import java.util.List;

import com.hr.tmapp.domain.Customer;

public interface CustomerDAO {

	public void save(Customer customer);
	public void update(Customer customer);
	public void delete(Customer customer);
	public void delete(Integer customerId);
	public Customer findById(Integer customerId);
	public List<Customer> findAll();
	public List<Customer> findByProperty(String propName, Object propValue);
}
