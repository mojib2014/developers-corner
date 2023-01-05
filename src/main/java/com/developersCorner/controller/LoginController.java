package com.developersCorner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.developersCorner.model.LoginForm;

@Controller
@RequestMapping("/users")
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("loginForm");
	
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(@ModelAttribute("loginForm") @Validated LoginForm form) {
		ModelAndView mv = new ModelAndView();
		
		LoginForm newUser = new LoginForm(form.getEmail(), form.getPassword());
		
		System.out.println(newUser.getEmail());
		mv.setViewName("loginForm");
		mv.addObject("user", newUser.getEmail());
		
		return mv;
	}
}
