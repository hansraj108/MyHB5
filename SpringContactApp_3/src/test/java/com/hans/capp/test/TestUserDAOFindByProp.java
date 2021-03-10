package com.hans.capp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hans.capp.config.SpringRootConfig;
import com.hans.capp.dao.UserDAO;
import com.hans.capp.domain.User;

public class TestUserDAOFindByProp {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		
		List<User> user = userDAO.findByProperty("name","Amit");
		
		for(User u : user) {
			System.out.println(u.getUserId()+" "+u.getName()+" "+u.getLoginName()+" "+u.getPassword());
		}
	        System.out.println("--------Data Saved------");
	}
}
