package com.developersCorner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("message", "Hi ther!");
		return mv;
	}
	
	@RequestMapping(value = "/greet")
	public ModelAndView greet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		mv.addObject("message", "Hi ther! greet handler method");
		return mv;
	}
	
}
