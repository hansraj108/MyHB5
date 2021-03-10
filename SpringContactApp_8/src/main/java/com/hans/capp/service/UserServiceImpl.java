package com.hans.capp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.hans.capp.dao.BaseDAO;
import com.hans.capp.dao.UserDAO;
import com.hans.capp.domain.User;
import com.hans.capp.exception.UserBlockedException;
import com.hans.capp.rm.UserRowMapper;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public void register(User u) {
		userDAO.save(u);
		
	}

	public User loginUser(String userName, String password) throws UserBlockedException {
		String sql = "SELECT userid, name, phone, email, address, loginname, role, loginstatus "
				+ "FROM user WHERE loginname=:ln AND password =:pw ";
		
		Map m = new HashMap();
		m.put("ln", userName);
		m.put("pw", password);
		SqlParameterSource ps = new MapSqlParameterSource(m);
		
		try {
			User user = getNamedParameterJdbcTemplate().queryForObject(sql, ps, new UserRowMapper());
			if(user.getLoginStatus().equals(LOGIN_STATUS_BLOCKED)) {
				throw new UserBlockedException("Your login is blocked please contact Admin");
			}else {
				return user;
			}
			
		} catch (EmptyResultDataAccessException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return null;
		}
	}

	public List<User> getUserList() {
		return userDAO.findByProperty("role", UserService.ROLE_USER);
		
	}

	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		String sql = "UPDATE user SET loginstatus = :loginStatus WHERE userid = :userId";
		Map m = new HashMap();
		m.put("loginStatus", loginStatus);
		m.put("userId", userId);
		SqlParameterSource ps = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, ps);
		
		
	}

	public Boolean isUsernameExists(String userName) {
		String sql = "SELECT count(loginName) FROM user WHERE loginName = ?";
		Integer count = getJdbcTemplate().queryForObject(sql, new String[]{userName}, Integer.class);
		if(count == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	 

}
