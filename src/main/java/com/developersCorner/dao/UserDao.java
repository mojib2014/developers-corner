package com.developersCorner.dao;

import java.util.List;

import com.developersCorner.model.User;

public interface UserDao {
	
	List<User> findAllUsers();
	User findById(Long id);
	User findByName(String name);
	void saveUser(User user);
	void updateUser(User user);
	void deleteById(Long id);
}
