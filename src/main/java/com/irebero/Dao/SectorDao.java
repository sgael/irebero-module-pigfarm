package com.irebero.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.irebero.Domain.Sector;

public interface SectorDao extends CrudRepository<Sector, String>{

	Sector findByName(String secname);
	List<Sector>findAll();
}
