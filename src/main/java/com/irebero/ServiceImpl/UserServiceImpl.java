package com.irebero.ServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.irebero.Dao.RoleDao;
import com.irebero.Dao.UserDao;
import com.irebero.Domain.User;
import com.irebero.Security.UserRole;
import com.irebero.Service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public User findByUsername(String username) {
		
		return userDao.findByusername(username);
	}
	@Override
	public User findByEmail(String email) {
	
		return userDao.findByemail(email);
	}
	@Override
	public boolean checkEmailExists(String email) {
		if(null !=findByEmail(email)) {
			return true;
		}
		return false;
	}
	@Override
	public boolean checkUsernameExists(String username) {
		if(null != findByUsername(username)) {
			return true;
		}
		return false;
	}
	@Override
	public boolean checkUserExists(String username, String email) {
		if(checkUsernameExists(username)||checkEmailExists(email)) {
			return true;
		}else {
		return false;
		}
	}
	
//	@Override
//	public void SendNotification(User user) {
//		// TODO Auto-generated method stub
//		
//	}
	@Override
	public User findBycode(String id) {
		// TODO Auto-generated method stub
		return userDao.findBycode(id);
	}
@Override
public User createUser(User user, Set<UserRole> userRoles) {
	User localUser = userDao.findByusername(user.getUsername());

	if (localUser != null) {
		logger.info("User with username {} already exist. Nothing will be done.", user.getUsername());
	} else {
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);

		for (UserRole ur : userRoles) {
				System.out.println(ur.getRole());
			roleDao.save(ur.getRole());
		}

		user.getUserRoles().addAll(userRoles);

		localUser = userDao.save(user);
	}
	return localUser;
}

@Override
public String userRole(Authentication auth) {
	Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
	List<String> roles = new ArrayList<String>();
	String role = "";
	for (GrantedAuthority a : authorities) {
		roles.add(a.getAuthority());
		role = a.getAuthority();
	}

	return role;
}
@Override
public void save(User user) {
	
	userDao.save(user);
}
@Override
public User saveuser(User user) {
	String encryptedPassword = passwordEncoder.encode(user.getPassword());
	user.setPassword(encryptedPassword);
	return userDao.save(user);
}
	
}