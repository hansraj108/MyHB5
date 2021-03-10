package com.hr.service;

import java.util.List;

import com.hr.domain.User;
import com.hr.exception.UserBlockedException;

public interface UserService {
	
	public static final Integer LOGIN_STATUS_ACTIVE = 1;
	public static final Integer LOGIN_STATUS_BLOCKED = 2;
	
	public static final Integer ROLE_ADMIN = 1;
	public static final Integer ROLE_USER = 2;

	public void register(User u);
	
	//	if login don't succeed it will return null
	public User login (String loginName, String password) throws UserBlockedException;
	
	public List<User> getUserList();
	
	public void changeLoginStatus(String userId, Integer loginStatus);
}
