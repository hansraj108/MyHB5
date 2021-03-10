package com.hans.capp.dao;

import java.util.List;

import com.hans.capp.domain.User;

public interface UserDAO {

	public void save(User user);
	public void update(User user, Integer id);
	public void delete(User user);
	public void delete(Integer userId);
	public User findById(Integer userId);
	public List<User> findAll();
	public List<User> findByProperty(String propName, Object PropValue);
	
}
