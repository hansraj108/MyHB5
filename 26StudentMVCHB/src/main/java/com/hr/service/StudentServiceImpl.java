package com.hr.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hr.bean.Student;
import com.hr.dao.AbstractDAO;
import com.hr.dao.StudentDAO;
import com.hr.exception.StudentException;
import com.hr.util.StringUtil;

@Service
@Transactional
public class StudentServiceImpl extends AbstractDAO implements StudentService {

	@Autowired
	private SessionFactory sessionFactory;
	
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
		Session session = sessionFactory.getCurrentSession();
		String ids = StringUtil.toCommaSeparatedString(studIds);
		Query query = session.createQuery("DELETE FROM STUDENT20 WHERE ID IN (:ids)");
		query.setString("ids", ids);
		
		

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
		
	//	String sql = "SELECT ID, NAME, DOB, MOBILE, COUNTRY FROM STUDENT20 WHERE id LIKE '%"+txt+"%' OR name LIKE '%"+txt+"%' OR mobile LIKE '%"+txt+"%' OR country LIKE '%"+txt+"%'";
		Query query = getSession().createQuery("SELECT id, name, dob, mobile, country FROM Student WHERE name like :txt OR mobile like :txt OR country like :txt");
        query.setString("txt", "%"+txt);
       
        return query.list();
		/* return getJdbcTemplate().query(sql, new StudentRowMapper()); */
		/* return new ArrayList<Student>() {}; */
        
	}

	
}
