package com.bean;

import java.io.Serializable;

//�û���
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email = "";
	private String username = "";
	private String password = "";
	private String phone = "";

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
