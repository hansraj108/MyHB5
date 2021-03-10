package com.hr.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hr.model.UserDocument;

@Repository("UserDocumentDao")
public class UserDocumentDaoImpl extends AbstractDao<Integer, UserDocument> implements UserDocumentDao{

	public List<UserDocument> findAll() {
		Criteria crit = createEntityCriteria();
		return (List<UserDocument>)crit.list();
	}

	@SuppressWarnings("unchecked")
	public UserDocument findById(int id) {
		return getByKey(id);
	}

	public void save(UserDocument document) {
		persist(document);
		
	}

	@SuppressWarnings("unchecked")
	public List<UserDocument> findAllByUserId(int userId) {
		Criteria crit = createEntityCriteria();
		Criteria userCriteria = crit.createCriteria("user");
		userCriteria.add(Restrictions.eq("id", userId));
		return (List<UserDocument>)crit.list();
	}

	public void deleteById(int id) {
		UserDocument document =  getByKey(id);
		delete(document);
		
	}

}
