package com.developersCorner.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.developersCorner.dto.AuthResponse;
import com.developersCorner.dto.UserLoginDto;
import com.developersCorner.dto.UserRegistrationDto;
import com.developersCorner.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthService authService;
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	// ----------------- Register user ----------------------------
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<AuthResponse> register(@Valid @RequestBody UserRegistrationDto dto) {
		logger.info("register contrroler {}", dto);
		AuthResponse authResponse = authService.register(dto);
	
		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@Valid @RequestBody UserLoginDto dto) {
		AuthResponse authResponse = authService.authenticate(dto);
		
		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.OK);
	}

}
