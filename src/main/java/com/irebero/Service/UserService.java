package com.irebero.Service;

import java.util.Set;

import org.springframework.security.core.Authentication;

import com.irebero.Domain.User;
import com.irebero.Security.UserRole;

public interface UserService {
	boolean checkEmailExists(String email);
	boolean checkUsernameExists(String username);
	boolean checkUserExists(String username, String email);
	
	User findByUsername(String username);
	User findByEmail(String email);
	String userRole(Authentication auth);
	void save (User user) ;
	User createUser(User user, Set <UserRole> userRoles);
	User saveuser (User user);
//	User findOne(Long id); 
//	UserHasDocument findusedoc(Long id);
//	void SendNotification(User user);
	User findBycode(String id);
}
