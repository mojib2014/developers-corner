package com.developersCorner.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserLoginDto {

	@NotNull(message = "Email is required and must be a valid email")
	private String email;
	
	@NotNull(message = "Password is required and must be at least 6 characters")
	@Size(message = "Password must be at least 6 characters", min = 6, max = 20)
	private String password;
	
	public UserLoginDto() {}
	
	public UserLoginDto(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLoginDto other = (UserLoginDto) obj;
		return Objects.equals(password, other.password) && Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "LoginForm [email=" + email + ", password=" + password + "]";
	}
	
}