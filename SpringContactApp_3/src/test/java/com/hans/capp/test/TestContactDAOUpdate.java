package com.hans.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hans.capp.config.SpringRootConfig;
import com.hans.capp.dao.ContactDAO;
import com.hans.capp.domain.Contact;

public class TestContactDAOUpdate {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO = ctx.getBean(ContactDAO.class);
		
		 //TODO: the user details will be taken from Update User Profile Page
        Contact c = new Contact();
        c.setContactId(116);
        c.setName("tan");
        c.setPhone("8888");
        c.setEmail("dd@gmai");
        c.setAddress("srt");
        c.setRemark("new");
       
        
        contactDAO.update(c);
        System.out.println("--------Data Updated------");
	}
}
