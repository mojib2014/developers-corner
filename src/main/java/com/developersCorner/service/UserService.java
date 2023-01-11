package com.developersCorner.service;

import java.util.List;

import com.developersCorner.dto.UserRegistrationDto;
import com.developersCorner.model.User;

public interface UserService {
	
	List<User> findAllUsers();
	User findById(Long id);
	User findByEmail(String email);
	void saveUser(UserRegistrationDto user);
	void updateUser(Long id, UserRegistrationDto user);
	void deleteById(Long id);
}
