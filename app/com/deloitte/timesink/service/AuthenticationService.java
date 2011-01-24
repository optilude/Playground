package com.deloitte.timesink.service;

/**
 * Primitive authentication operations
 */
public interface AuthenticationService {

	/**
	 * Authenticate a user
	 */
	public boolean authenticate(String username, String password);
	
	/**
	 * Determine if the given user has the given role
	 */
	public boolean hasRole(String username, String role);
	
}
