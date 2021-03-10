package com.tailormaster.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tailormaster.app.domain.User;
import com.tailormaster.app.rm.UserRowMapper;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO{

	public void save(User user) {
		String sql = "INSERT INTO user (FirstName, LastName, Phone, Email, Address, City, State, Country, LoginName, Password, Role, LoginStatus) "
				+ "VALUES (:firstname, :latName, :phone, :email, :address, :city, :state, :country, :loginName, :password, :role, :loginStatus)";
		Map m = new HashMap();
		m.put("firstname", user.getFirstName());
		m.put("lastName", user.getLastName());
		m.put("phone",user.getPhone());
		m.put("email",user.getEmail());
		m.put("address",user.getAddress());
		m.put("city", user.getCity());
		m.put("state", user.getState());
		m.put("country", user.getCountry());
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

	public void update(User user, Integer id) {
		String sql = "UPDATE user "
                + " SET FirstName=:firstName,"
                + " LastName=:lastName, "
                + " Phone=:phone, "
                + " Email=:email,"
                + " Address=:address,"
                + " City=:city, "
                + " State=:state, "
                + " Country=:country, "
                + " role=:role,"
                + " loginStatus=:loginStatus "
                + " WHERE UserId= "+id;
        Map m = new HashMap();
        m.put("firstname", user.getFirstName());
		m.put("lastName", user.getLastName());
		m.put("phone",user.getPhone());
		m.put("email",user.getEmail());
		m.put("address",user.getAddress());
		m.put("city", user.getCity());
		m.put("state", user.getState());
		m.put("country", user.getCountry());
		m.put("role",user.getRole());
		m.put("loginStatus",user.getLoginStatus());
       
        SqlParameterSource ps = new MapSqlParameterSource(m);
        getNamedParameterJdbcTemplate().update(sql, ps);
	}

	public void delete(User user) {
		this.delete(user.getUserId());
		
	}

	public void delete(Integer userId) {
		String sql = "DELETE FROM user WHERE userID=?";
		getJdbcTemplate().update(sql, userId);
		
	}

	public User findById(Integer userId) {
		String sql = "SELECT UserID, FirstName, LastName, Phone, Email, Address, City, State, Country, LoginName, Role, LoginStatus "
				+ " FROM user WHERE UserID=?";
		User user = getJdbcTemplate().queryForObject(sql, new UserRowMapper(),userId);
		return user;
	}

	public List<User> findAll() {
		String sql = "SELECT UserID, FirstName, LastName, Phone, Email, Address, City, State, Country, LoginName, Role, LoginStatus "
				+ "FROM user";
		return getJdbcTemplate().query(sql, new UserRowMapper());
	}

	public List<User> findByProperty(String propName, Object PropValue) {
		String sql = "SELECT UserID, FirstName, LastName, Phone, Email, Address, City, State, Country, LoginName, Role, LoginStatus  "
				+ "FROM user WHERE "
				+ propName +"= ?";
		return getJdbcTemplate().query(sql, new UserRowMapper(), PropValue);
	}

}
