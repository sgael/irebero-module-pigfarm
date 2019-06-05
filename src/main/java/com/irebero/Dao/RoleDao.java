package com.irebero.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irebero.Security.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {
		Role findByName(String name);
		@Query("from Role where roleId!=0")
		List<Role> findAllRoles();
		
}
