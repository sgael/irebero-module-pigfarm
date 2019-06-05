package com.irebero.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irebero.Dao.DistrictDao;
import com.irebero.Domain.District;
import com.irebero.Service.DistrictService;

@Service
public class DistrServiceImpl implements DistrictService{

	@Autowired
	DistrictDao disdao;
	@Override
	public District findOne(String dna) {
		// TODO Auto-generated method stub
		return disdao.findByProvince(dna);
	}

}
