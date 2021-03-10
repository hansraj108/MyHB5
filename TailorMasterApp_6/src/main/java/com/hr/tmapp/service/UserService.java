package com.hr.tmapp.service;

import java.util.List;

import com.hr.tmapp.domain.User;
import com.hr.tmapp.exception.UserBlockedException;

public interface UserService {

	public static final Integer LOGIN_STATUS_ACTIVE = 1;
	public static final Integer LOGIN_STATUS_BLOCKED = 2;
	
	public static final Integer ROLE_ADMIN = 1;
	public static final Integer ROLE_USER = 2;
	public void register(User u);
	public User loginUser(String userName, String password) throws UserBlockedException;
	public List<User> getUserList();
	public void changeLoginStatus(Integer userId, Integer loginStatus);
	public Boolean isUsernameExists(String userName);
	public User findByUserId(Integer userId);
	public void deleteById(Integer id);
	public void updateUser(User user, Integer id);
	
}
