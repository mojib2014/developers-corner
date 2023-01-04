package com.developersCorner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.developersCorner.model.RegisterForm;

@Controller
public class RegisterController {

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registerForm");
		
		return mv;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("registerForm") RegisterForm form) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("registerForm");
		mv.addObject("message", "Succefully registered!");
		return mv;
	}
}
