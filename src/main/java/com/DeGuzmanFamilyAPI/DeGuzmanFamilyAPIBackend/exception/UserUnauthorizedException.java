package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception;

public class UserUnauthorizedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2219531250731013764L;

	public UserUnauthorizedException(String message) {
		super(message);
	}
}
