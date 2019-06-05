package com.irebero.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.irebero.Domain.User;

public interface UserDao extends CrudRepository<User, Long> {
	User findByusername(String username);
	List<User> findAll();
	User findByemail(String email);
	User findByid(Long id);
	User findBycode(String id);
}
