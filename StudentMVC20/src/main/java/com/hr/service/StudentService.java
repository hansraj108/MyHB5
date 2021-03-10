package com.hr.service;

import java.text.ParseException;
import java.util.List;

import com.hr.bean.Student;
import com.hr.exception.StudentException;


/**
 * The interface specifies all business operation for Contact Entity.
 *
 * @author Vikram
 */
public interface StudentService {

    public void save(Student c) throws ParseException, StudentException;

    public void update(Student c) throws ParseException, StudentException;

    public void delete(Integer studId);
   
    /**
     * Bulk delete
     * @param cotactIds 
     */
    public void delete(Integer[] studIds);
    
    public Student findById(Integer studId);

    /**
     * This method returns all User Contact (user who is logged in).
     *
     * @param userId
     * @return
     */
    
    /**
     * The method search contact for user(userId) based on given
     * free-text-criteria (txt)
     *
     * @param userId User who is logged in
     * @param txt criteria used to search - free text search criteria
     * @return
     * @throws StudentException 
     */
    public List<Student> findStudent( String txt) throws StudentException;

	List<Student> findAllStudent();
}
