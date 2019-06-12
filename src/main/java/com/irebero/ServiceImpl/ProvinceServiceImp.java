package com.irebero.ServiceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irebero.Dao.ProvinceDao;
import com.irebero.Domain.Province;
import com.irebero.Service.ProvinceService;

@Service
@Transactional
public class ProvinceServiceImp implements ProvinceService{
	
	@Autowired
	private ProvinceDao provinceDao;

	@Override
	public void save(Province province) {
		provinceDao.save(province);
	}

	@Override
	public List<Province> findAll() {
		return (List<Province>) provinceDao.findAll();
	}

	@Override
	public Province findByName(String name) {
		return provinceDao.findByName(name);
	}

	@Override
	public Province findById(Long id) {
		return provinceDao.findById(id).get();
	}

}
