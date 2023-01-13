package com.developersCorner.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "First Name is required and must be at least 5 characters long")
	@Size(min = 5, max = 20)
	private String firstName;

	@NotNull(message = "Last Name is required and must be at least 5 characters long")
	@Size(min = 5, max = 20)
	private String lastName;

	private String nickName;

	@NotNull(message = "Email is required and must be a valid email")
	private String email;

	@NotNull(message = "Password is required and must be at least 6 characters long")
	@Size(min = 6, max = 20)
	private String password;

	@NotNull(message = "Role is a required field")
	private String role;

	@Column(nullable = false, columnDefinition = "TIMESTAMP")
	private LocalDateTime createdAt;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonBackReference("user")
	private List<Question> questions;

	public User() {
	}

	public User(Long id, String firstName, String lastName, String nickName, String email, String password, String role,
			LocalDateTime createdAt, List<Question> questions) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdAt = createdAt;
		this.questions = questions;
	}

	public User(String firstName, String lastName, String nickName, String email, String password, String role,
			LocalDateTime createdAt, List<Question> questions) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdAt = createdAt;
		this.questions = questions;
	}

	public User(
			@NotNull(message = "First Name is required and must be at least 5 characters long") @Size(min = 5, max = 20) String firstName,
			@NotNull(message = "Last Name is required and must be at least 5 characters long") @Size(min = 5, max = 20) String lastName,
			String nickName, @NotNull(message = "Email is required and must be a valid email") String email,
			@NotNull(message = "Password is required and must be at least 6 characters long") @Size(min = 6, max = 20) String password,
			@NotNull(message = "Role is a required field") String role, LocalDateTime createdAt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, email, firstName, id, lastName, nickName, password, questions, role);
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
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(nickName, other.nickName)
				&& Objects.equals(password, other.password) && Objects.equals(questions, other.questions)
				&& Objects.equals(role, other.role);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nickName=" + nickName
				+ ", email=" + email + ", password=" + password + ", role=" + role + ", createdAt=" + createdAt
				+ ", questions=" + questions + "]";
	}

}
