package com.developersCorner.model;

public class Chat {

	private Long id;
	private String username;
	private Long userId;
	private String message;
	
	
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
		return "Chat [id=" + id + ", username=" + username + ", userId=" + userId + ", message=" + message + "]";
	}

	
}
