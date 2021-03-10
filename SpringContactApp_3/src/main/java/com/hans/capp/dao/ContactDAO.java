package com.hans.capp.dao;

import java.util.List;

import com.hans.capp.domain.Contact;
import com.hans.capp.domain.User;

public interface ContactDAO {

	public void save(Contact contact);
	
	public void update(Contact contact);
	
	public void delete(Contact contact);
	
	public void delete(Integer contactId);
	
	public Contact findById(Integer contactId);
	
	public List<Contact> findAll();
	
	public List<Contact> findByProperty(String propName, Object propValue);
}
