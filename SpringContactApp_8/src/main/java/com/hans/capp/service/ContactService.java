package com.hans.capp.service;

import java.util.List;

import com.hans.capp.domain.Contact;

public interface ContactService {

	public void save (Contact c);
	public void update(Contact c);
	public void delete(Integer contactId);
	public void deleteAll(Integer[] contactIds);
	public List<Contact> findUserContact(Integer userId);
	public List<Contact> findUserContact(Integer userId, String text);
	Contact findById(Integer contactId);
}
