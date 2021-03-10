package com.javatpoint.mapper;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatpoint.beans.Emp;

public class EmpMapper implements RowMapper<Emp> {

	@Override
	public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
		Emp emp = new Emp();
		emp.setId(rs.getInt("id"));
		emp.setName(rs.getString("name"));
		emp.setDesignation(rs.getString("designation"));
		emp.setSalary(rs.getInt("salary"));
		
		return emp;
	}

	

}
