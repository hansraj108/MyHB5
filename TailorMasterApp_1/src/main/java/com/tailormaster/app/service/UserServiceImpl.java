package com.tailormaster.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.tailormaster.app.dao.BaseDAO;
import com.tailormaster.app.dao.UserDAO;
import com.tailormaster.app.domain.User;
import com.tailormaster.app.exception.UserBlockedException;
import com.tailormaster.app.rm.UserRowMapper;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public void register(User u) {
		userDAO.save(u);
		
	}

	public User loginUser(String userName, String password) throws UserBlockedException {
		String sql = "UserID, FirstName, LastName, Phone, Email, Address, City, State, Country, LoginName, Role, LoginStatus  "
				+ "FROM user WHERE LoginName=:ln AND Password =:pw ";
		
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
		String sql = "UPDATE user SET LoginStatus = :loginStatus WHERE UserID = :userId";
		Map m = new HashMap();
		m.put("loginStatus", loginStatus);
		m.put("userId", userId);
		SqlParameterSource ps = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, ps);
		
	}
	
	public Boolean isUsernameExists(String userName) {
		String sql = "SELECT count(LoginName) FROM user WHERE LoginName = ?";
		Integer count = getJdbcTemplate().queryForObject(sql, new String[]{userName}, Integer.class);
		if(count == 1) {
			return true;
		}else {
			return false;
		}
	}

	public User findByUserId(Integer userId) {
		String sql = "SELECT UserID, FirstName, LastName, Phone, Email, Address, City, State, Country, LoginName, Role, LoginStatus  " 
				+" FROM user WHERE UserID = ?";
		return getJdbcTemplate().queryForObject(sql, new UserRowMapper(), userId);
	}

	
	public void deleteById(Integer id) {
		userDAO.delete(id);
		
	}


	public void updateUser(User user,Integer id) {
		userDAO.update(user,id);
		
	}
}
