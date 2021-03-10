package com.student.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


import com.student.beans.Student;
import com.student.mapper.StudentMapper;

public class StudentDaoImpl implements StudentDao{  
	
	
	public NamedParameterJdbcTemplate template;  
	
    
public StudentDaoImpl(NamedParameterJdbcTemplate template) {
		super();
		this.template = template;
	}

	 final String SAVE_STUDENT_QUERY = "insert into student(name,mobile,dob,country) values(:name,:mobile,:dob,:country)";
	 final String UPDATE_STUDENT_QUERY = "update student set name=:name,mobile=:mobile,dob=:dob,country=:country where id=:id";
	 final String DELETE_STUDENT_QUERY = "delete from student where id=:id";
	 final String SELECT_STUDENT_QUERY = "select id, name, mobile,dob,country from student where id=:id";
	 final String GET_ALL_STUDENT_QUERY = "select * from student";
	
	 
	 @Override
		public void save(Student s) {
		 Map<String,Object> map = new HashMap<String, Object>();
			map.put("name", s.getName());
			map.put("mobile", s.getMobile());
			map.put("dob", s.getDob());
			map.put("country", s.getCountry());
			
			template.update(SAVE_STUDENT_QUERY,map);
		}

		@Override
		public void update(Student s) {
			KeyHolder holder = new GeneratedKeyHolder();
			SqlParameterSource param = new MapSqlParameterSource()
					.addValue("id", s.getId())
					.addValue("name", s.getName())
					.addValue("mobile", s.getMobile())
					.addValue("date", s.getDob())
					.addValue("country", s.getCountry());
			template.update(UPDATE_STUDENT_QUERY, param,holder);
			
		}

		@Override
		public void deleteStudentById(int id) {
			Map<String,Object> map=new HashMap<String,Object>();  
			 map.put("id",id);

			 template.execute(DELETE_STUDENT_QUERY,map,new PreparedStatementCallback<Object>() {  
			    @Override  
			    public Object doInPreparedStatement(PreparedStatement ps)  
			            throws SQLException, DataAccessException {  
			        return ps.executeUpdate();  
			    }  
			});
			
		}

		@Override
		public Student getStudentById(int id) {
			SqlParameterSource param = new MapSqlParameterSource("id", Integer.valueOf(id));
			Student student = template.queryForObject(SELECT_STUDENT_QUERY, param, new StudentMapper());
			return student;
		}

		@Override
		public List<Student> getStudents() {
			List<Student> student = template.query(GET_ALL_STUDENT_QUERY, new StudentMapper());
			return student;
		}


		
}