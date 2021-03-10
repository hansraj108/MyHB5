package com.hans.capp.dao;

import java.util.List;

import com.hans.capp.domain.UserDocument;

public interface UserDocumentDAO {
	
	void save (UserDocument document);
	
	void deleteById(int id);
	
	UserDocument findById(int id);
	
	List<UserDocument> findAllByUserId(int userId);

	List<UserDocument> findAll();

	
	
	
	
	
	
	
}
