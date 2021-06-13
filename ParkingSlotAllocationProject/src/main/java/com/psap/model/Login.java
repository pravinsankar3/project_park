package com.psap.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Login")
public class Login implements Serializable{

	@Id
	private String loginId;
	private String password;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private User user;
	@OneToMany(mappedBy="role",cascade=CascadeType.ALL)
	private Role role;
	
	// Constructors, Getter & Setter method
	
	public Login() {
		super();
	}
	
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

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", password=" + password + ", user=" + user + ", role=" + role + "]";
	}
	
	
}
