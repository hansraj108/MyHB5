package com.hr.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hr.bean.Student;
import com.hr.util.StringUtil;

public class StudentRowMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student s = new Student();
		s.setId(rs.getInt("id"));
		s.setName(rs.getString("name"));
		s.setMobile(rs.getLong("mobile"));
		s.setDob(StringUtil.getStringDOB(rs.getDate("dob")));
		s.setCountry(rs.getString("country"));
		return s;
	}
	
	
	
	

}
