package com.hans.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.hans.capp.domain.User;
import com.hans.capp.rm.UserRowMapper;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO{

	public void save(User user) {
		String sql = "INSERT INTO user (name, phone, email, address, loginName, password, role, loginStatus) "
				+ "VALUES (:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
		Map m = new HashMap();
		m.put("name",user.getName());
		m.put("phone",user.getPhone());
		m.put("email",user.getEmail());
		m.put("address",user.getAddress());
		m.put("loginName",user.getLoginName());
		m.put("password",user.getPassword());
		m.put("role",user.getRole());
		m.put("loginStatus",user.getLoginStatus());
		
		SqlParameterSource ps = new MapSqlParameterSource(m);
		KeyHolder kh = new GeneratedKeyHolder();
		
		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		Integer userId = kh.getKey().intValue();
		user.setUserId(userId);
	}

	public void update(User u) {
		String sql = "UPDATE user "
                + " SET name=:name,"
                + " phone=:phone, "
                + " email=:email,"
                + " address=:address,"
                + " role=:role,"
                + " loginStatus=:loginStatus "
                + " WHERE userId=:userId";
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());       
        m.put("role", u.getRole());
        m.put("loginStatus", u.getLoginStatus());
        m.put("userId", u.getUserId());
        SqlParameterSource ps = new MapSqlParameterSource(m);
        getNamedParameterJdbcTemplate().update(sql, ps);
	}

	public void delete(User user) {
		this.delete(user.getUserId());
		
	}

	public void delete(Integer userId) {
		String sql = "DELETE FROM user WHERE userId=?";
		getJdbcTemplate().update(sql, userId);
		
	}

	public User findById(Integer userId) {
		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus "
				+ " FROM user WHERE userId=?";
		User user = getJdbcTemplate().queryForObject(sql, new UserRowMapper(),userId);
		return user;
	}

	public List<User> findAll() {
		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus  "
				+ "FROM user";
		return getJdbcTemplate().query(sql, new UserRowMapper());
	}

	public List<User> findByProperty(String propName, Object PropValue) {
		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus  "
				+ "FROM user WHERE "
				+ propName +"= ?";
		return getJdbcTemplate().query(sql, new UserRowMapper(), PropValue);
	}

}
