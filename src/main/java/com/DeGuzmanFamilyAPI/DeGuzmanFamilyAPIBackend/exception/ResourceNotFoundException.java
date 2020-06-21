package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception;

public class ResourceNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -585870861123120517L;
	public static final Long serialVersionID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
