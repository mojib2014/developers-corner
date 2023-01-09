package com.developersCorner.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.developersCorner.model.LoginForm;
import com.developersCorner.model.RegisterForm;
import com.developersCorner.model.User;
import com.developersCorner.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	@RequestMapping(value = "/users/register", method = RequestMethod.POST)
	public ResponseEntity<Void> register(@RequestBody @Valid RegisterForm form) {
		System.out.println("register contrroler " + form.toString());
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("registerForm");
//		mv.addObject("message", "Succefully registered!");
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(@Valid @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()) {
			bindingResult
			.getFieldErrors()
			.stream()
			.forEach(f -> mv.addObject("errors", f.getField() + ": " + f.getDefaultMessage()));
			 mv.setViewName("loginForm");
			return mv;
		}else {
			LoginForm newUser = new LoginForm(form.getEmail(), form.getPassword());
			
			System.out.println(newUser.getEmail());
			mv.setViewName("loginForm");
			mv.addObject("user", newUser.getEmail());
			
			return mv;			
		}
		
	}
	
	// -------------------- Retrieve All Users ---------------------------------
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
	
	// ------------------------- Retrieve A User By Id-----------------------------
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@RequestParam("id") Long id) {
		User user = userService.findById(id);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
