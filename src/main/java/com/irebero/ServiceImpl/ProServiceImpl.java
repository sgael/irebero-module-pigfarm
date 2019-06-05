package com.irebero.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irebero.Dao.ProvinceDao;
import com.irebero.Domain.Province;
import com.irebero.Service.ProvinceService;

@Service
public class ProServiceImpl implements ProvinceService{

	@Autowired
	ProvinceDao pdao;
	@Override
	public Province findOne(String pname) {
		// TODO Auto-generated method stub
		return pdao.findByPname(pname);
	}

}
