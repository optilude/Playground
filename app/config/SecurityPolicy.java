package config;

import javax.inject.Inject;

import com.deloitte.timesink.service.AuthenticationService;

import controllers.Secure;

public class SecurityPolicy extends Secure.Security {

	@Inject
	public static AuthenticationService authenticationService;
	
	static boolean authenticate(String username, String password) {
        return authenticationService.authenticate(username, password);
    }
	
	static boolean check(String profile) {
        String username = session.get("username");
        if(username == null) {
        	return false;
        }
        
        return authenticationService.hasRole(username, profile);
    }
	
}
