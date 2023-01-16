package com.developersCorner.service;

import com.developersCorner.dto.AuthResponse;
import com.developersCorner.dto.UserLoginDto;
import com.developersCorner.dto.UserRegistrationDto;

public interface AuthService {
	AuthResponse register(UserRegistrationDto dto);
	AuthResponse authenticate(UserLoginDto dto);
}
