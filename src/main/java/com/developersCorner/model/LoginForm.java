package com.developersCorner.model;

import java.util.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class LoginForm {

	@NotNull(message = "email is required and must be a valid email")
	@Email
	private String email;
	private String password;
	
	public LoginForm() {}
	
	public LoginForm(String email, String password) {
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
		LoginForm other = (LoginForm) obj;
		return Objects.equals(password, other.password) && Objects.equals(email, other.email);
	}
	
	
}
