package com.hans.capp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hans.capp.domain.UserDocument;

public class UserDocumentRowmapper implements RowMapper<UserDocument> {

	
	public UserDocument mapRow(ResultSet rs, int rowNum) throws SQLException {

		UserDocument ud = new UserDocument();
		ud.setId(rs.getInt("id"));
		ud.setUserId(rs.getInt("userId"));
		ud.setName(rs.getString("name"));
		ud.setDescription(rs.getString("description"));
		ud.setType(rs.getString("type"));
		ud.setContent(rs.getBytes("content"));
		return ud;
	}

}
