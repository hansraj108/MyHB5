package com.hans.capp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hans.capp.config.SpringRootConfig;
import com.hans.capp.dao.ContactDAO;
import com.hans.capp.domain.Contact;
import com.hans.capp.domain.User;

public class TestContactDAOFindByProp {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO = ctx.getBean(ContactDAO.class);
		
		List<Contact> contact = contactDAO.findByProperty("name", "tan");
		for(Contact c : contact) {
			System.out.println(c.getName()+" "+c.getPhone()+" "+c.getContactId() );
		}
	        System.out.println("--------Data find------");
	}
}
