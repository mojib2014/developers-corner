package com.developersCorner.service;

import java.time.LocalDate;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developersCorner.dao.UserDao;
import com.developersCorner.dto.AuthResponse;
import com.developersCorner.dto.UserLoginDto;
import com.developersCorner.dto.UserRegistrationDto;
import com.developersCorner.model.User;
import com.developersCorner.security.JwtService;

@Service("authService")
@Transactional
public class AuthServiceImpl implements AuthService {
	private final UserDao userDao;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public AuthServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder, 
			JwtService jwtService, AuthenticationManager authManager) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authManager;
	}
	
	@Override
	public AuthResponse register(UserRegistrationDto dto) {
		User user = new User(
					dto.getFirstName(), 
					dto.getLastName(), 
					dto.getNickName(),
					dto.getEmail(), 
					passwordEncoder.encode(dto.getPassword()), 
					dto.getType(), 
					LocalDate.now()
				);
		userDao.saveUser(user);
		String jwtToken = jwtService.generateToken(user);
		
		return new AuthResponse(jwtToken);
	}
	
	@Override
	public AuthResponse authenticate(UserLoginDto dto) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
		User user = userDao.findByEmail(dto.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Username not found"));;
		String jwtToken = jwtService.generateToken(user);
		return new AuthResponse(jwtToken);
	}
}
