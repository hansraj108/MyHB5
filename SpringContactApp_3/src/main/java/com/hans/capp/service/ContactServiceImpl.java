package com.hans.capp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hans.capp.dao.BaseDAO;
import com.hans.capp.dao.ContactDAO;
import com.hans.capp.domain.Contact;
import com.hans.capp.rm.ContactRowMapper;
import com.hans.capp.util.StringUtil;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService{

	@Autowired
	private ContactDAO contactDAO;
	
	@Override
	public void save(Contact c) {
		contactDAO.save(c);
		
	}

	@Override
	public void update(Contact c) {
		contactDAO.update(c);
		
	}

	@Override
	public void delete(Integer contactId) {
		contactDAO.delete(contactId);
		
	}

	@Override
	public void deleteAll(Integer[] contactIds) {
		String ids = StringUtil.toCommaSeparatedString(contactIds);
		String sql = "DELETE FROM contact WHERE contactId IN ("+ids+")";
		getJdbcTemplate().update(sql);
		
	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		return contactDAO.findByProperty("userId", userId);
		
	}

	@Override
	public List<Contact> findUserContact(Integer userId, String text) {
		String sql = "SELECT contactId, userId, name, phone, email, address, remark "
				+ "FROM contact WHERE userId=? AND (name LIKE '%"+text+"%' OR address LIKE '%"+text+"%' OR contactId LIKE '%"+text+"%' OR email LIKE '%"+text+"%' OR phone LIKE '%"+text+"%' OR remark LIKE '%"+text+"%')";
		return getJdbcTemplate().query(sql, new ContactRowMapper(), userId);
	}

	@Override
	public Contact findById(Integer contactId) {
		return contactDAO.findById(contactId);
		
	}

}
