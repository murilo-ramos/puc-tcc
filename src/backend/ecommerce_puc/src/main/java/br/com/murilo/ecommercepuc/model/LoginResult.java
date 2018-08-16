package br.com.murilo.ecommercepuc.model;

import br.com.murilo.ecommercepuc.entity.User;

public class LoginResult {
	
	private boolean loginSuccessful;
	private User user;
	private String message;	
	
	public boolean isLoginSuccessful() {
		return loginSuccessful;
	}

	public void setLoginSuccessful(boolean loginSuccessful) {
		this.loginSuccessful = loginSuccessful;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
