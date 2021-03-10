package com.hr.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hr.config.SpringRootConfig;
import com.hr.dao.UserDAO;
import com.hr.domain.User;

public class TestUserDAODeleteUserId {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User u = new User();
		 userDAO.delete(7);
	        System.out.println("--------Data DELETED------");
	}
}
