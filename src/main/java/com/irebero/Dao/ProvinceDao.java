package com.irebero.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.irebero.Domain.Province;

public interface ProvinceDao extends CrudRepository<Province, String> {

	Province findByPname (String pname);
	List<Province>findAll();
	
}
