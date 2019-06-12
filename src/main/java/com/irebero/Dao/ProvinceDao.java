package com.irebero.Dao;

import org.springframework.data.repository.CrudRepository;

import com.irebero.Domain.Province;

public interface ProvinceDao extends CrudRepository<Province, Long>{
	Province findByName(String name);

Province findByid(Long id);
}
