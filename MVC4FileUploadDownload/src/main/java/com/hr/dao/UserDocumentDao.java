package com.hr.dao;

import java.util.List;

import com.hr.model.UserDocument;

public interface UserDocumentDao {

	List<UserDocument> findAll();

	UserDocument findById(int id);
	
	void save (UserDocument document);
	
	List<UserDocument> findAllByUserId(int userId);
	
	void deleteById(int id);
}
