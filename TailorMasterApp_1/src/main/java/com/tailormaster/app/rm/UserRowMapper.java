package com.tailormaster.app.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tailormaster.app.domain.User;

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int i) throws SQLException {
		
		User u = new User();
		u.setUserId(rs.getInt("userID"));
		u.setFirstName(rs.getString("FirstName"));
		u.setLastName(rs.getString("LastName"));
		u.setPhone(rs.getString("Phone"));
		u.setEmail(rs.getString("Email"));
		u.setAddress(rs.getString("Address"));
		u.setCity(rs.getString("City"));
		u.setState(rs.getString("State"));
		u.setCountry(rs.getString("Country"));
		u.setLoginName(rs.getString("LoginName"));
		u.setRole(rs.getInt("Role"));
		u.setLoginStatus(rs.getInt("LoginStatus"));
		return u;
	}

}
