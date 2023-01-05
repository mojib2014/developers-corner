package com.developersCorner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.developersCorner.model.User;

@RestController
public class UserController {

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = new ArrayList<>();
		
		User user = new User(1, "John", "Doe", "john.doe@email.com", "password");
		User user2 = new User(1, "Mojib", "Mohammad", "mojib.mohammad@email.com", "password");
		User user3 = new User(1, "David", "Garcia", "david.doe@email.com", "password");
		User user4 = new User(1, "Tom", "Jerry", "tom.doe@email.com", "password");
		users.add(user);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
