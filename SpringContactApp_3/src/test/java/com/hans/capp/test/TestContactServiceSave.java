package com.hans.capp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hans.capp.config.SpringRootConfig;
import com.hans.capp.domain.Contact;
import com.hans.capp.service.ContactService;

public class TestContactServiceSave {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactService contactService = ctx.getBean(ContactService.class);
		Contact c = new Contact();
		
		c.setName("hans2");
		c.setEmail("gmaol@com");
		c.setAddress("nsd");
		c.setPhone("9999");
		c.setUserId(14);
		c.setRemark("by default");
		contactService.save(c);
	        System.out.println("--------Data Saved------");
	}
}
