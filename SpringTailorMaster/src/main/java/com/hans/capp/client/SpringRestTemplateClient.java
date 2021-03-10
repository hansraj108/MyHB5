package com.hans.capp.client;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.hans.capp.domain.User;


public class SpringRestTemplateClient {

	public static final String REST_BASE_URI = "http://localhost:8080/SpringContactApp_9/restuser/";
	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String [] args) {
	
	
	
		User u = new User();
		u.setName("hans");
		u.setPhone("9427");
		u.setEmail("hans@gmail.com");
		u.setAddress("nvs");
		u.setLoginName("haxxl");
		u.setPassword("123");
		u.setRole(2);
		u.setLoginStatus(1);
		
	//	u = restTemplate.postForObject(REST_BASE_URI+"register", u, User.class);
		
	//	User getUser = restTemplate.getForObject(REST_BASE_URI+"userById/10.json", User.class);
		
	//	restTemplate.delete(REST_BASE_URI+"deleteUser/10");
		
	User updateUser = new User();
	updateUser.setName("hansjjjj");
	updateUser.setPhone("9427");
	updateUser.setEmail("hans@gmail.com");
	updateUser.setAddress("nvs");
	updateUser.setLoginName("haxxl");
	updateUser.setPassword("123");
	updateUser.setRole(2);
	updateUser.setLoginStatus(1);
		
//	restTemplate.put(REST_BASE_URI+"/updateUser/4", updateUser);
	
	List<User> userList = restTemplate.getForObject(REST_BASE_URI+"/usersList.json", List.class);
	for(Object u2 : userList) {
		System.out.println(u2);
	}
	
	}
	}

