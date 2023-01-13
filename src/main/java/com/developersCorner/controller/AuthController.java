package com.developersCorner.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/users/user/auth")
public class AuthController {

	@Autowired
	private UserService userService;
	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	// ----------------- Register user ----------------------------
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Void> register(@RequestBody @Valid UserRegistrationDto form) {
		logger.info("register contrroler {}", form);
		userService.saveUser(form);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	// ------------------- Login user --------------------------
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(@Valid @ModelAttribute("loginForm") UserLoginDto form, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		if (bindingResult.hasErrors()) {
			bindingResult.getFieldErrors().stream()
					.forEach(f -> mv.addObject("errors", f.getField() + ": " + f.getDefaultMessage()));
			mv.setViewName("loginForm");
			return mv;
		} else {
			UserLoginDto newUser = new UserLoginDto(form.getEmail(), form.getPassword());

			logger.info("Logging in {}", form);
			mv.setViewName("loginForm");
			mv.addObject("user", newUser.getEmail());

			return mv;
		}

	}

}
