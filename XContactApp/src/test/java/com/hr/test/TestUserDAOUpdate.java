package com.hr.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hr.config.SpringRootConfig;
import com.hr.dao.UserDAO;
import com.hr.domain.User;

public class TestUserDAOUpdate {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		
		 //TODO: the user details will be taken from Update User Profile Page
        User u=new User();
        u.setUserId(13);
        u.setName("Amit Sinha");
        u.setPhone("9303580884");
        u.setEmail("amit.sinha@ezeon.net");
        u.setAddress("Mumbai, MS");        
        u.setRole(1);//Admin Role 
        u.setLoginStatus(1); //Active
        
        userDAO.update(u);
        System.out.println("--------Data Updated------");
	}
}
