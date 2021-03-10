package com.spring.studentmanagement.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.studentmanagement.pojo.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudentFirstName(rs.getString("studentFirstName"));
		student.setStudentLastName(rs.getString("studentLastName"));
		student.setStudentId(rs.getInt("studentId"));
		student.setStudentEmailId(rs.getString("studentEmailId"));
		student.setLogonPassword(rs.getString("logonPassword"));
		return student;
		
	}

	
}
