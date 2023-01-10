package com.developersCorner.service;

import java.util.List;

import com.developersCorner.model.User;

public interface UserService {
	
	List<User> findAllUsers();
	User findById(Long id);
	User findByName(String name);
	void saveUser(User user);
	void updateUser(User user);
	void deleteById(Long id);
}
