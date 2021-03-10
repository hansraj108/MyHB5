package com.hans.capp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.hans.capp.dao.BaseDAO;
import com.hans.capp.dao.UserDAO;
import com.hans.capp.domain.User;
import com.hans.capp.exception.UserBlockedException;
import com.hans.capp.rm.USerRowMapper;

@Service
public class UserServiceImpl extends BaseDAO implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public void register(User u) {
		userDAO.save(u);
	}

	@Override
	public User login(String loginName, String password) throws UserBlockedException {
		String sql = "SELECT userid, name, phone, email, address, loginname, role, loginstatus "
				+ "from user where loginname=:ln AND password=:pw";
		Map m = new HashMap();
		m.put("ln",loginName);
		m.put("pw",password);
		SqlParameterSource ps = new MapSqlParameterSource(m);
		
		try {
			User u = getNamedParameterJdbcTemplate().queryForObject(sql, ps, new USerRowMapper());
			if(u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
				throw new UserBlockedException("Your login is blocked please contact Admin");
			}else {
			return u;
			}
		}catch(EmptyResultDataAccessException ex) {
			
			return null;
			
		}
	}
	

	@Override
	public List<User> getUserList() {
		return userDAO.findByProperty("role", UserService.ROLE_USER);
	}

	@Override
	public void changeLoginStatus(String userId, Integer loginStatus) {
		// TODO Auto-generated method stub
		
	}

}
