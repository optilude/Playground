package com.deloitte.timesink.service;

import static com.google.common.base.Preconditions.checkNotNull;

public class AuthenticationServiceImpl implements AuthenticationService {

	public boolean authenticate(String username, String password) {
		checkNotNull(username);
		checkNotNull(password);
		
		// Uh-oh...
		return username.equals("admin") && password.equals("password"); 
	}
	
	@Override
	public boolean hasRole(String username, String role) {
		checkNotNull(username);
		checkNotNull(role);
		
		// More uh-oh
		return username.equals("admin") && role.equals("admin");
	}

}
