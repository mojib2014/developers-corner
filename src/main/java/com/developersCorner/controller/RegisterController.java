package com.developersCorner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.developersCorner.model.RegisterForm;

@RestController
@RequestMapping("/users")
public class RegisterController {

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registerForm");
		
		return mv;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ResponseEntity<Void> register(@RequestBody @Validated RegisterForm form) {
		System.out.println("register contrroler " + form.toString());
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("registerForm");
//		mv.addObject("message", "Succefully registered!");
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
