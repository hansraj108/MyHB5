package com.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hr.dao.UserDocumentDao;
import com.hr.model.UserDocument;

@Service("userDocumentService")
@Transactional
public class UserDocumentServiceImpl implements UserDocumentService {

	@Autowired
	UserDocumentDao dao;
	
	public UserDocument findById(int id) {
		return dao.findById(id);
	}

	public List<UserDocument> findAll() {
		return dao.findAll();
	}

	public List<UserDocument> findAllByUserId(int userId) {
		return dao.findAllByUserId(userId);
	}

	public void saveDocument(UserDocument document) {
		dao.save(document);
		
	}

	public void deleteById(int id) {
		dao.deleteById(id);
		
	}

}
