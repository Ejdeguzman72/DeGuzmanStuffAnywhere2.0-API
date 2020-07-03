package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.authentication_models;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	public static final Long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;
	
	public JwtRequest() {
	
	}

	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	public static Long getSerialversionuid() {
		return serialVersionUID;
	}
}
