package com.hans.capp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hans.capp.config.SpringRootConfig;
import com.hans.capp.dao.ContactDAO;
import com.hans.capp.domain.Contact;
import com.hans.capp.domain.User;

public class TestContactDAOFind {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO = ctx.getBean(ContactDAO.class);
		
		Contact contact = contactDAO.findById(116);
		
		
			System.out.println(contact.getName()+" "+contact.getPhone()+" "+contact.getContactId() );
		
	        System.out.println("--------Data find------");
	}
}
