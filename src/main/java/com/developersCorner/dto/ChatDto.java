package com.developersCorner.dto;

public class ChatDto {
	
	private String username;
	private Long userId;
	private String message;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "ChatDto [username=" + username + ", userId=" + userId + ", message=" + message + "]";
	}
	
	
}
