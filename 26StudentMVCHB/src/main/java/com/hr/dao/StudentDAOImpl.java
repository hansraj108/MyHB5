package com.hr.dao;
import java.text.ParseException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hr.bean.Student;
import com.hr.exception.StudentException;
import com.hr.util.StringUtil;

@Repository
public class StudentDAOImpl extends AbstractDAO implements StudentDAO {

	
	
	@Override
	public void save(Student s) throws ParseException, StudentException {
		persist(s);
				
	}

	@Override
	public void update(Student s) throws ParseException, StudentException {
		getSession().update(s);	
        
	}

	@Override
	public void delete(Student s) {
		this.deleteById(s.getId());

	}

	@Override
	public void deleteById(Integer id) {
		Query query = getSession().createSQLQuery("delete from student20 where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
	}

	@Override
	public Student findById(Integer id) {
		Criteria criteria = getSession().createCriteria(Student.class);
        criteria.add(Restrictions.eq("id",id));
        return (Student) criteria.uniqueResult();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll() {
		Criteria criteria = getSession().createCriteria(Student.class);
        return (List<Student>) criteria.list();
	}
	@Override

	public List<Student> findByProrperty(String propName, Object propValue) {
		/*
		 * Session session = sessionFactory.getCurrentSession(); return session.
		 * createSQLQuery("SELECT ID, NAME, DOB, MOBILE, COUNTRY FROM STUDENT20 WHERE ? = ?"
		 * ).setParameter(1, "propName").setParameter(2, propValue).list();
		 */
		Query query = getSession().createQuery("SELECT ID, NAME, DOB, MOBILE, COUNTRY FROM STUDENT20 WHERE :propName = :propValue");
        query.setString("propName", propName);
        query.setString("propValue", (String)propValue);
        return query.list();
		
	}

	
		
		
	}

