package com.irebero.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.irebero.Domain.PenTable;

public interface PenDao extends CrudRepository<PenTable, Long>{
	List<PenTable>findAll();
	
	PenTable findByid(Long id);
	
	PenTable findByCategory(String ca);

}
