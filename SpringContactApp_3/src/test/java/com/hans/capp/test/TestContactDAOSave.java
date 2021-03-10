package com.hans.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hans.capp.config.SpringRootConfig;
import com.hans.capp.dao.ContactDAO;
import com.hans.capp.domain.Contact;

public class TestContactDAOSave {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO = ctx.getBean(ContactDAO.class);
		Contact c = new Contact();
		
		c.setName("hans");
		c.setEmail("gmaol@com");
		c.setAddress("nsd");
		c.setPhone("9999");
		c.setUserId(14);
		c.setRemark("by default");
		    contactDAO.save(c);
	        System.out.println("--------Data Saved------");
	}
}
