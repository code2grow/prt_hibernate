package com.preetham.dto;

import java.util.List; 

import com.preetham.models.User;

public class SaveResponse {

	
	private String content;
	private String errorContent;
	private boolean errorFlag;
	private List<User> userData;
	private User user;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getErrorContent() {
		return errorContent;
	}

	public void setErrorContent(String errorContent) {
		this.errorContent = errorContent;
	}

	public boolean isErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(boolean errorFlag) {
		this.errorFlag = errorFlag;
	}

	public List<User> getUserData() {
		return userData;
	}

	public void setUserData(List<User> userData) {
		this.userData = userData;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
