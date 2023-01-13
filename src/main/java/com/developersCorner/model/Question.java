package com.developersCorner.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "username is required field")
	private String username;

	@NotNull(message = "Tags is required field")
	private String tags;

	@NotNull(message = "Question is required field")
	private String question;

	@Column(nullable = false, columnDefinition = "TIMESTAMP")
	private LocalDateTime createdAt;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", nullable = false)
	@JsonManagedReference("questions")
	private User user;

	public Question() {
	}

	public Question(Long id, String username, String tags, String question, LocalDateTime createdAt, User user) {
		super();
		this.id = id;
		this.username = username;
		this.tags = tags;
		this.question = question;
		this.createdAt = createdAt;
		this.user = user;
	}

	public Question(String username, String tags, String question, LocalDateTime createdAt, User user) {
		super();
		this.username = username;
		this.tags = tags;
		this.question = question;
		this.createdAt = createdAt;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, id, question, tags, user, username);
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
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(id, other.id)
				&& Objects.equals(question, other.question) && Objects.equals(tags, other.tags)
				&& Objects.equals(user, other.user) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", username=" + username + ", tags=" + tags + ", question=" + question
				+ ", createdAt=" + createdAt + ", user=" + user + "]";
	}

}
