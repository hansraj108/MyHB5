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
import com.hans.capp.rm.USerRowMapper;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	@Override
	public void save(User user) {
		String sql = "INSERT INTO user (name, phone, email, address, loginName, password, role, loginStatus)"
					 + " VALUES (:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";
		
		Map map = new HashMap();
		map.put("name",user.getName());
		map.put("phone", user.getPhone());
		map.put("email",user.getEmail());
		map.put("address",user.getAddress());
		map.put("loginName",user.getLoginName());
		map.put("password",user.getPassword());
		map.put("role",user.getRole());
		map.put("loginStatus",user.getLoginStatus());
		
		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(map);
		super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
		
		Integer userId = kh.getKey().intValue();
		user.setUserId(userId);
		
	}

	@Override
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

	@Override
	public void delete(User u) {
		this.delete(u.getUserId());
		
	}

	@Override
	public void delete(Integer userId) {
		String sql = "DELETE FROM user WHERE userId=?";
		getJdbcTemplate().update(sql,userId);
		
	}

	@Override
	public User findById(Integer userId) {
		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user WHERE userId=?";
				
		User u = getJdbcTemplate().queryForObject(sql,new USerRowMapper(),userId);
		return u;
		
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user";
				
		return getJdbcTemplate().query(sql,new USerRowMapper());
		
	}

	@Override
	public List<User> findByProperty(String propName, Object propValue) {
		String sql = "SELECT userId, name, phone, email, address, loginName, role, loginStatus"
                + " FROM user WHERE "+propName +"=?";
		return getJdbcTemplate().query(sql, new USerRowMapper(), propValue);
	}

}
