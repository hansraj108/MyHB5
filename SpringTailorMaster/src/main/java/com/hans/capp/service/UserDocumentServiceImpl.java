package com.hans.capp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hans.capp.dao.BaseDAO;
import com.hans.capp.dao.UserDocumentDAO;
import com.hans.capp.domain.Contact;
import com.hans.capp.domain.UserDocument;
import com.hans.capp.rm.ContactRowMapper;
import com.hans.capp.rm.UserDocumentRowmapper;
import com.hans.capp.util.StringUtil;

@Service
public class UserDocumentServiceImpl extends BaseDAO implements UserDocumentService {

	@Autowired
	private UserDocumentDAO userDocumentDAO;
	
	public void save(UserDocument ud) {
		userDocumentDAO.save(ud);
		
	}

	
	public void delete(Integer id) {
		userDocumentDAO.deleteById(id);
		
	}

	public void deleteAll(Integer[] ids) {
		
		String idsWithComma = StringUtil.toCommaSeperatedString(ids);
		String sql = "DELETE FROM user_document WHERE id IN ("+idsWithComma+")";
		getJdbcTemplate().update(sql);
		
	}

	public List<UserDocument> findAllUserDocument(Integer userId) {
		
		List<UserDocument> allUserDoc = userDocumentDAO.findAllByUserId(userId);
		
		return allUserDoc;
				
		
	}							

	public List<UserDocument> findUserDocument(Integer userId, String text) {
		String sql = "SELECT id, userID, name, description, type, content "
				+ "FROM user_document WHERE userId = ? AND (name LIKE '%"+text+"%' OR description LIKE '%"+text+"%' OR type LIKE '%"+text+"%' OR content LIKE '%"+text+"%') ";
		return getJdbcTemplate().query(sql, new UserDocumentRowmapper(), userId);
	}

	public UserDocument findById(Integer id) {
		return userDocumentDAO.findById(id);
	}

}
