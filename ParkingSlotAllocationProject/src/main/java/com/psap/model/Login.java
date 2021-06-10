package com.psap.model;

public class Login {
	private String loginId;
	private String password;
	private User user;
	private Role role;
	
	// Constructors, Getter & Setter method
	
	public Login(String loginId, String password, User user, Role role) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.user = user;
		this.role = role;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
}
