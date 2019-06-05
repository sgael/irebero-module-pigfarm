package com.irebero.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.irebero.Dao.SectorDao;
import com.irebero.Domain.Sector;
import com.irebero.Service.SectorService;

public class SecServiceImpl implements SectorService{

	@Autowired
	SectorDao secDao;
	@Override
	public Sector findOne(String sec) {
		// TODO Auto-generated method stub
		return secDao.findByName(sec);
	}

}
