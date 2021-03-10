package com.hans.capp.service;

import java.util.List;

import com.hans.capp.domain.UserDocument;

public interface UserDocumentService {

	public void save (UserDocument ud);
	public void delete(Integer id);
	public void deleteAll(Integer[] ids);
	public List<UserDocument> findAllUserDocument(Integer userId);
	public List<UserDocument> findUserDocument(Integer userId, String text);
	public UserDocument findById(Integer id);
}
