package com.developersCorner.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	@RequestMapping(value = "/errors", method = RequestMethod.GET)
	public ModelAndView renderErrorPage(HttpServletRequest httpServletRequest) {
		ModelAndView errorPage = new ModelAndView("errorPage");
		String errorMessage = "";
		int httpErrorCode = getErrorCode(httpServletRequest);
		
		switch(httpErrorCode) {
			case 400: {
				errorMessage = "Http Error Code: 400. Bad Request";
				break;
			}
			case 401: {
				errorMessage = "Http Error Code: 401. Unauthorized";
				break;
			}
			case 404: {
				errorMessage = "Http Error Code: 404. Resource not Found";
				break;
			}
			case 500: {
				errorMessage = "Http Error Code: 500. Internal Server Error";
				break;
			}
		}
		errorPage.addObject("errorMessage", errorMessage);
		return errorPage;
	}

	
	private int getErrorCode(HttpServletRequest httpRequest) {
		return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
	}
}
