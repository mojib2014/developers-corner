package com.developersCorner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.developersCorner.model.LoginForm;

@Controller
public class MainController {
	
	@RequestMapping(value = "/",  method = RequestMethod.GET)
	public String index() {
		return "index";
	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "loginForm";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register() {
		return "registerForm";
	}
}
