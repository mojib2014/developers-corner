package com.developersCorner.model;

import java.util.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterForm {
	
	@NotNull(message = "First Name is required and must be at least 5 characters long")
	@Size(min = 5, max = 20)
	private String firstName;
	
	@NotNull(message = "Last Name is required and must be at least 5 characters long")
	@Size(min = 5, max = 20)
	private String lastName;
	
	@NotNull(message = "email is required and must be a valid email")
	@Email
	private String email;
	
	@NotNull(message = "Password is required and must be at least 6 characters long")
	@Size(min = 6, max = 20)
	private String password;
	
	
	public RegisterForm() {}
	
	public RegisterForm(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return Objects.hash(firstName, lastName, password, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterForm other = (RegisterForm) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "RegisterForm [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
}