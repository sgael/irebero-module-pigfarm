package com.irebero.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irebero.Dao.DistrictDao;
import com.irebero.Domain.District;
import com.irebero.Domain.Province;
import com.irebero.Service.DistrictService;

@Service
@Transactional
public class DistrictServiceImp implements DistrictService{

	@Autowired
	private DistrictDao districtDao;
	
	@Override
	public void save(District district) {
		districtDao.save(district);
	}

	@Override
	public List<District> findAllByProvince(Province province) {
		return districtDao.findAllByProvince(province);
	}

	@Override
	public District findById(Long id) {
		return districtDao.findById(id).get();
	}


}
