package com.irebero.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.irebero.Domain.PigFarmingUsers;

public interface OwnerDao extends CrudRepository<PigFarmingUsers, Long> {

	List<PigFarmingUsers>findAll();
	PigFarmingUsers findByid(Long id);
	PigFarmingUsers findByPhone(String phone);
}
