package com.irebero.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.irebero.Domain.Pigsty;

public interface PigstyDao extends CrudRepository<Pigsty, Long> {
	List<Pigsty> findAll();
	Pigsty findByOwner(String owner);
	Pigsty findByid(Long id);

}
