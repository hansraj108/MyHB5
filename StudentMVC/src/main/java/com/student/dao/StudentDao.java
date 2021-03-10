package com.student.dao;

import java.util.List;

import com.student.beans.Student;

public interface StudentDao {

	//to save indiaviual data
	public abstract void save(Student p);
	
	//to update a record by its id
	public abstract void update(Student p);
	
	//to delete a record by id
	public abstract void deleteStudentById(int id);
	
	//retrieve a record by id
	public abstract Student getStudentById(int id);
	
	//retrieve all students
	public abstract List<Student> getStudents();
	
}
