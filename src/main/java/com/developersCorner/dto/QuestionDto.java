package com.developersCorner.dto;

import javax.validation.constraints.NotNull;


public class QuestionDto {
	
	@NotNull(message = "Username is required field")
	private String username;
	
	@NotNull(message = "Tags is required field")
	private String tags;
	
	@NotNull(message = "Question is required field")
	private String question;
	
	@NotNull(message = "User Id is required field")
	private Long userId;

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
	
	
}
