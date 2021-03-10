package com.hr.tmapp.service;

import java.util.List;

import com.hr.tmapp.domain.Customer;

public interface CustomerService {
	

	public void save (Customer c);
	public void update(Customer c);
	public void delete(Integer customerId);
	public void deleteAll(Integer[] customerId);
	public List<Customer> findUserCustomer(Integer userId);
	public List<Customer> findUserCustomer(Integer userId, String text);
	public Customer findById(Integer customerId);
}
