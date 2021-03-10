package com.hr.dao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.hr.bean.Student;
import com.hr.exception.StudentException;
import com.hr.rm.StudentRowMapper;
import com.hr.util.StringUtil;

@Repository
public class StudentDAOImpl extends BaseDAO implements StudentDAO {

	@Override
	public void save(Student s) throws ParseException, StudentException {
		String sql = "INSERT INTO STUDENT20 (name, dob, mobile, country) "
				+ "VALUES (:name, :dob, :mobile, :country)";
		
		Map m = new HashMap();
		m.put("name",s.getName());
		m.put("dob",StringUtil.sqlDate(s.getDob()));
		m.put("mobile",s.getMobile() );
		m.put("country",s.getCountry());
		
		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		
		s.setId(kh.getKey().intValue());
				
	}

	@Override
	public void update(Student s) throws ParseException, StudentException {
		String sql = "UPDATE STUDENT20 SET " +"name=:name, "+ "dob=:dob, "+ "mobile=:mobile, "+ "country=:country "+" WHERE id=:id";
				
		Map m = new HashMap();
		m.put("id", s.getId());
		m.put("name",s.getName());
		m.put("dob",StringUtil.sqlDate(s.getDob()));
		m.put("mobile",s.getMobile() );
		m.put("country",s.getCountry());
		
		SqlParameterSource ps = new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, ps);
	}

	@Override
	public void delete(Student s) {
		this.deleteById(s.getId());

	}

	@Override
	public void deleteById(Integer id) {
		String sql = "DELETE FROM STUDENT20 WHERE ID=?";
		getJdbcTemplate().update(sql, id);

	}

	@Override
	public Student findById(Integer id) {
		String sql = "SELECT ID, NAME, DOB, MOBILE, COUNTRY FROM STUDENT20 WHERE ID = ?";
		return getJdbcTemplate().queryForObject(sql,  new StudentRowMapper(),id);
		
	}

	@Override
	public List<Student> findAll() {
		String sql = "SELECT ID, NAME, DOB, MOBILE, COUNTRY FROM STUDENT20";
		return getJdbcTemplate().query(sql, new StudentRowMapper());
	}

	@Override
	public List<Student> findByProrperty(String propName, Object propValue) {
		String sql = "SELECT ID, NAME, DOB, MOBILE, COUNTRY FROM STUDENT20 WHERE propName = ?";
		
		return getJdbcTemplate().query(sql, new StudentRowMapper(),propValue);
	}

	
		
		
	}

