package com.developersCorner.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.developersCorner.dto.UserLoginDto;
import com.developersCorner.dto.UserRegistrationDto;
import com.developersCorner.model.User;
import com.developersCorner.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	//-------------------- Retrieve All Users ---------------------------------
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers(Exception e) {
		List<User> users = userService.findAllUsers();
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	//------------------------- Retrieve A User By Id-----------------------------
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
		User user = userService.findById(id);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	//------------------------- Retrieve A User By Email -----------------------------
	@RequestMapping(value = "/users/email/{email}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserByEmail(@PathVariable(value="email") String email) {
		User user = userService.findByEmail(email);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	//----------------------- Update a user by id -------------------
	@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUserById(@PathVariable(value = "id") Long id, @RequestBody @Valid UserRegistrationDto dto) {
		userService.updateUser(id, dto);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUserById(@PathVariable(value = "id") Long id) {
		userService.deleteById(id);
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
}
