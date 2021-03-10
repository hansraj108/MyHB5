package com.hans.capp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hans.capp.config.SpringRootConfig;
import com.hans.capp.domain.Contact;
import com.hans.capp.service.ContactService;

public class TestContactServiceFind {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactService contactService = ctx.getBean(ContactService.class);
		
		List<Contact> cl = contactService.findUserContact(14);
		Contact c = new Contact();
		for(Contact c1 : cl) {
			c.setContactId(c1.getContactId());
			c.setEmail(c1.getEmail());
			c.setAddress(c1.getAddress());
			c.setPhone(c1.getPhone());
			c.setName(c1.getName());
			c.setRemark(c1.getRemark());
		}
			        System.out.println(c.getContactId());
	}
}
