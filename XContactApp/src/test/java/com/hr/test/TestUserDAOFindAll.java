package com.hr.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hr.config.SpringRootConfig;
import com.hr.dao.UserDAO;
import com.hr.domain.User;

public class TestUserDAOFindAll {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		
		List<User> user = userDAO.findAll();
		
		for(User u : user) {
			System.out.println(u.getUserId()+" "+u.getName()+" "+u.getLoginName());
		}
	        System.out.println("--------Data Saved------");
	}
}
