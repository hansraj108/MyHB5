package com.hr.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.bean.Student;
import com.hr.dao.BaseDAO;
import com.hr.dao.StudentDAO;
import com.hr.exception.StudentException;
import com.hr.rm.StudentRowMapper;
import com.hr.util.StringUtil;

@Service
public class StudentServiceImpl extends BaseDAO implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public void save(Student s) throws ParseException, StudentException {
		studentDAO.save(s);

	}

	@Override
	public void update(Student s) throws ParseException, StudentException {
		studentDAO.update(s);

	}

	@Override
	public void delete(Integer studId) {
		studentDAO.deleteById(studId);

	}

	@Override
	public void delete(Integer[] studIds) {
		String ids = StringUtil.toCommaSeparatedString(studIds);
		String sql = "DELETE FROM STUDENT20 WHERE ID IN ("+ids+")";
		getJdbcTemplate().update(sql);
		

	}

	@Override
	public Student findById(Integer studId) {
		return studentDAO.findById(studId);
	}

	@Override
	public List<Student> findAllStudent() {
		return studentDAO.findAll();
	}

	@Override
	public List<Student> findStudent(String txt) throws StudentException {
		String sql = "SELECT ID, NAME, DOB, MOBILE, COUNTRY FROM STUDENT20 WHERE id LIKE '%"+txt+"%' OR name LIKE '%"+txt+"%' OR DOB LIKE '%"+txt+"%' OR mobile LIKE '%"+txt+"%' OR country LIKE '%"+txt+"%'";
        return getJdbcTemplate().query(sql, new StudentRowMapper()); 
	}

	
}
