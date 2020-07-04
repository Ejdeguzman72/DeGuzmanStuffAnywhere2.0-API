package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.authentication_models;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1170030078581028411L;
	private final String jwttoken;
	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
	public String getToken() {
		return this.jwttoken;
	}
	
}
