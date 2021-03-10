package com.hans.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hans.capp.config.SpringRootConfig;
import com.hans.capp.domain.User;
import com.hans.capp.service.UserService;

public class TestUserServiceRegister {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		User u = new User();
		 u.setName("Hansraj");
	        u.setPhone("9427007181");
	        u.setEmail("amit@ezeon.net");
	        u.setAddress("Mumbai");
	        u.setLoginName("hans1");
	        u.setPassword("hans123");
	        u.setRole(userService.ROLE_ADMIN);//Admin Role 
	        u.setLoginStatus(userService.LOGIN_STATUS_ACTIVE); //Active
	        userService.register(u);
	        System.out.println("--------Data Saved------");
	}
}
