package com.hr.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hr.bean.Student;
import com.hr.config.SpringRootConfig;
import com.hr.dao.StudentDAO;

public class TestUserDAOUpdate {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		StudentDAO userDAO = ctx.getBean(StudentDAO.class);
		
		 //TODO: the user details will be taken from Update User Profile Page
        Student u=new Student();
        u.setId(7);
        u.setName("Amit Sinha");
      //  u.setDob(new Date());
        
        
    //    userDAO.update(u);
        System.out.println("--------Data Updated------");
	}
	
	
}
