package com.hans.capp.conversion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hans.capp.domain.Contact;
import com.hans.capp.domain.User;

public class JavaToJson {

	public static void main(String[] args) throws JsonProcessingException {
		
		
		User u = new User();
		u.setName("hans");
		u.setPhone("9427");
		u.setEmail("hans@gmail.com");
		u.setAddress("nvs");
		u.setLoginName("hansss");
		u.setPassword("123");
		u.setRole(2);
		u.setLoginStatus(1);
		
		ObjectMapper mapper = new ObjectMapper();
		String userJson = mapper.writeValueAsString(u); 
		System.out.println(userJson);
		System.out.println("======================");
		
		Contact c = new Contact();
		c.setName("hansssss");
		c.setPhone("8866");
		c.setEmail("hn@gmil");
		c.setAddress("hyd");
		c.setRemark("friend");
		c.setUserId(1);
		
		ObjectMapper mapper1 = new ObjectMapper();
		String contactJson = mapper.writeValueAsString(c); 
		System.out.println(contactJson);
		System.out.println("======================");
		
		
	}
}
