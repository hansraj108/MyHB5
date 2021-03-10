package com.hans.capp.service;

import java.util.List;

import com.hans.capp.domain.Contact;

/**
 * @author DELL
 *
 */
public interface ContactService {
	
	public void save(Contact c);
	public void update(Contact c);
	public void delete (Integer contactId);
	public void deleteAll(Integer[] contactIds);
	public Contact findById(Integer contactId);
	
	
	public List<Contact> findUserContact(Integer userId);
	public List<Contact> findUserContact(Integer userId, String text);
	

}
