package com.developersCorner.model;

import java.util.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {

	private Integer id;
	
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
	
	
	public User() {
		
	}
	
	public User(Integer id, String firstName, String lastName, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public void setEmail(String Email) {
		this.email = Email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, password, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(email, other.email);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Email=" + email
				+ ", password=" + password + "]";
	}
	
	
}
