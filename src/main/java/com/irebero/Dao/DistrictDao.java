package com.irebero.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.irebero.Domain.District;

public interface DistrictDao extends CrudRepository<District, String>{

	District findByProvince (String dna);
	List<District>findAll();
}
