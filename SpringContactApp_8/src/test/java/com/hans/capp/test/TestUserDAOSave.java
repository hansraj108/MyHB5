package com.hans.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hans.capp.config.SpringRootConfig;
import com.hans.capp.dao.UserDAO;
import com.hans.capp.domain.User;

public class TestUserDAOSave {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User u = new User();
		 u.setName("Amit");
	        u.setPhone("9303580884");
	        u.setEmail("amit@ezeon.net");
	        u.setAddress("Mumbai");
	        u.setLoginName("amit1");
	        u.setPassword("amit123");
	        u.setRole(1);//Admin Role 
	        u.setLoginStatus(1); //Active
	        userDAO.save(u);
	        System.out.println("--------Data Saved------");
	}
}
