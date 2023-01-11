package com.developersCorner.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Username is required field")
	private String username;
	
	@NotBlank(message = "Tags is required field")
	private String tags;
	
	@NotBlank(message = "Question is required field")
	private String question;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User.class)
	private Long userId;
	
	public Question() {}

	public Question(Long id, @NotBlank(message = "Username is required field") String username,
			@NotBlank(message = "Tags is required field") String tags,
			@NotBlank(message = "Question is required field") String question, Long userId) {
		super();
		this.id = id;
		this.username = username;
		this.tags = tags;
		this.question = question;
		this.userId = userId;
	}

	public Question(@NotBlank(message = "Username is required field") String username,
			@NotBlank(message = "Tags is required field") String tags,
			@NotBlank(message = "Question is required field") String question, Long userId) {
		super();
		this.username = username;
		this.tags = tags;
		this.question = question;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, question, tags, userId, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		return Objects.equals(id, other.id) && Objects.equals(question, other.question)
				&& Objects.equals(tags, other.tags) && Objects.equals(userId, other.userId)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", username=" + username + ", tags=" + tags + ", question=" + question
				+ ", userId=" + userId + "]";
	}

}
