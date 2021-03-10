package com.hans.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.hans.capp.domain.UserDocument;
import com.hans.capp.rm.UserDocumentRowmapper;

@Repository
public class UserDocumentDAOImpl extends BaseDAO implements UserDocumentDAO{

	public List<UserDocument> findAll() {
		String sql = "SELECT id, userId, name, description, type, content "
				+ "FROM user_document";
		return getJdbcTemplate().query(sql, new UserDocumentRowmapper());
	}

	public UserDocument findById(int id) {
		String sql = "SELECT id, userId, name, description, type, content "
				+ "FROM user_document WHERE id = ?";
		return getJdbcTemplate().queryForObject(sql, new UserDocumentRowmapper(), id);
	}

	public void save(UserDocument document) {
		String sql = "INSERT INTO user_document (userId, name, description, type, content) "
				+ "VALUES (:userId, :name, :description, :type, :content )";
		Map m = new HashMap();
		m.put("userId", document.getUserId());
		m.putIfAbsent("name", document.getName());
		m.put("description", document.getDescription());
		m.put("type", document.getType());
		m.put("content", document.getContent());
		
		SqlParameterSource ps = new MapSqlParameterSource(m);
		KeyHolder kh = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		Integer id = kh.getKey().intValue();
		document.setId(id);
		System.out.println("public void save complete");
	}

	public List<UserDocument> findAllByUserId(int userId) {
		String sql = "SELECT id, userId, name, description, type, content "
				+ "FROM user_document WHERE userId = ?";
		List<UserDocument> allUserDoc = getJdbcTemplate().query(sql, new UserDocumentRowmapper(), userId);
		
		return allUserDoc;
	}

	public void deleteById(int id) {
		String sql = "DELETE FROM user_document WHERE id = ?";
		getJdbcTemplate().update(sql, id);
		
	}

}
