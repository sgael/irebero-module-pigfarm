package com.irebero.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.irebero.Dao.UserDao;
import com.irebero.Domain.User;


@Service
public class UserSecurityService implements UserDetailsService {
	
	private static final Logger LOG=LoggerFactory.getLogger(UserSecurityService.class);
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user=userDao.findByusername(username);
		if(null==user) {
			LOG.warn("Username {} not found", username);
			throw new UsernameNotFoundException("Username" + username +"not found");
		}
		return user;
	}
}
