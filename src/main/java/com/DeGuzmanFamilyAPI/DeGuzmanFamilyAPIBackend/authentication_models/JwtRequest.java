package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.authentication_models;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4100130385109161508L;
	private String username;
	private String password;
<<<<<<< HEAD
	private boolean enabled;
=======
	private boolean isEnabled;
>>>>>>> bbb24a810b45cff8dced2dec98f19a390d1fc731
	
	public JwtRequest() {
	
	}

	public JwtRequest(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
<<<<<<< HEAD
		this.enabled = enabled;
=======
		this.isEnabled = isEnabled;
>>>>>>> bbb24a810b45cff8dced2dec98f19a390d1fc731
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

	public boolean isEnabled() {
<<<<<<< HEAD
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
=======
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
>>>>>>> bbb24a810b45cff8dced2dec98f19a390d1fc731
}
