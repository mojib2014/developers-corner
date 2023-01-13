package com.developersCorner.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developersCorner.dao.UserDao;
import com.developersCorner.dto.UserRegistrationDto;
import com.developersCorner.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public User findById(Long id) {
		return userDao.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public void saveUser(UserRegistrationDto user) {
		User newUser = new User(user.getFirstName(), user.getLastName(), 
				user.getNickName(), user.getEmail(), user.getPassword(),
				user.getRole(), LocalDateTime.now());
		
		userDao.saveUser(newUser);
	}

	@Override
	public void updateUser(Long id, UserRegistrationDto dto) {
		User user = userDao.findById(id);
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setNickName(dto.getNickName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setRole(dto.getRole());
		userDao.updateUser(user);
	}

	@Override
	public void deleteById(Long id) {
		userDao.deleteById(id);
	}

}
