package com.irebero.ServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
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
		if (null != findByEmail(email)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkUsernameExists(String username) {
		if (null != findByUsername(username)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkUserExists(String username, String email) {
		if (checkUsernameExists(username) || checkEmailExists(email)) {
			return true;
		} else {
			return false;
		}
	}

	
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

	@Override
	public User findOne(Long id) {
		User us = new User();
		us = userDao.findByid(id);
		if (us == null) {
			System.out.println("here");
			return null;
		}
		return us;
	}

	private JavaMailSenderImpl javaMailSender;

	@Autowired
	public UserServiceImpl(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void SendNotification(User user) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setTo(user.getEmail());
		System.out.println("here is the email to be used" + user.getEmail());
		mail.setFrom("sengagael4@gmail.com");
		mail.setSubject("Notification from irebero pig-farm-management-system");
		mail.setText("http://localhost:8090/ConfirmPassword?idy=" + user.getCode());


		try {

			javaMailSender.send(mail);

		} catch (MailException e) {
			// TODO: handle exception

			System.out.println("error sending email :" + e.getMessage());

		}
	}

}