package com.hr.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hr.config.SpringRootConfig;
import com.hr.dao.UserDAO;
import com.hr.domain.User;

public class TestUserDAOFindById {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		
		User u = userDAO.findById(1);
		
		System.out.println(u.getUserId());
		System.out.println(u.getAddress());
		System.out.println(u.getEmail());
		System.out.println(u.getPhone());
		System.out.println(u.getLoginName());
		System.out.println(u.getLoginStatus());
		System.out.println(u.getName());
		System.out.println(u.getRole());
		System.out.println();
		System.out.println();
	        System.out.println("--------Data Saved------");
	}
}
