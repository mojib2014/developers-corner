package com.developersCorner.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistrationDto {

	@NotNull(message = "First Name is required and must be at least 5 characters long")
	@Size(min = 5, max = 20, message = "Last Name must be between 5 to 20 charactars long.")
	private String firstName;

	@NotNull(message = "Last Name is required and must be at least 5 characters long")
	@Size(min = 5, max = 20, message = "Last Name must be between 5 to 20 charactars long.")
	private String lastName;

	private String nickName;

	@NotNull(message = "email is required and must be a valid email")
	private String email;

	@NotNull(message = "Password is required and must be at least 6 characters long")
	@Size(min = 6, max = 20, message = "Password must be between 6 to 20 charactars long.")
	private String password;
	
	@NotNull(message = "Type is a required field")
	private String type;

	public UserRegistrationDto() {
	}

	public UserRegistrationDto(
			String firstName,
			String lastName,
			String nickName,
			String email,
			String password,
			String type) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
		this.type = type;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, lastName, nickName, password, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRegistrationDto other = (UserRegistrationDto) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(nickName, other.nickName)
				&& Objects.equals(password, other.password) && Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "UserRegistrationDto [firstName=" + firstName + ", lastName=" + lastName + ", nickName=" + nickName
				+ ", email=" + email + ", password=" + password + ", type=" + type + "]";
	}
}
