package com.hr.service;

import java.util.List;

import com.hr.model.UserDocument;

public interface UserDocumentService {

	UserDocument findById(int id);

	List<UserDocument> findAll();
	
	List<UserDocument> findAllByUserId(int userId);
	
	void saveDocument(UserDocument document);
	
	void deleteById(int id);
}