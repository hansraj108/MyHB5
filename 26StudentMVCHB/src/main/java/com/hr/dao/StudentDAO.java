package com.hr.dao;

import java.text.ParseException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hr.bean.Student;
import com.hr.exception.StudentException;

public interface StudentDAO {
	
	
	public void save(Student s) throws ParseException, StudentException;

	public void update(Student s) throws  StudentException, ParseException;

	public void delete(Student s);

	public void deleteById(Integer id);

	public Student findById(Integer id);

	public List<Student> findAll();

	public List<Student> findByProrperty(String propName, Object propValue);

}
