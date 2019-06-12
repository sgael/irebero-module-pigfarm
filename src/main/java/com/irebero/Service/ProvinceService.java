package com.irebero.Service;

import java.util.List;

import com.irebero.Domain.Province;

public interface ProvinceService {
	void save(Province province);
	Province findByName(String name);
	Province findById(Long id);
	List<Province> findAll();
}
