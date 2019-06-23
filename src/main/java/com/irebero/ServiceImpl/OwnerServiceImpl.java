package com.irebero.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irebero.Dao.OwnerDao;
import com.irebero.Domain.PigFarmingUsers;
import com.irebero.Service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	OwnerDao oDao;

	@Override
	public PigFarmingUsers saveowner(PigFarmingUsers owners) {

		return oDao.save(owners);
	}

	@Override
	public List<PigFarmingUsers> findowner() {
		// TODO Auto-generated method stub
		return oDao.findAll();
	}

	@Override
	public PigFarmingUsers findOne(Long id) {
		// TODO Auto-generated method stub
		return oDao.findByid(id);
	}

	@Override
	public void delete(PigFarmingUsers owner) {
		// TODO Auto-generated method stub
		oDao.delete(owner);
	}

	@Override
	public PigFarmingUsers findById(Long id) {
		// TODO Auto-generated method stub
		return oDao.findByid(id);
	}

	@Override
	public PigFarmingUsers findByNames(String names) {
		return oDao.findByNames(names);
	}

	



	
}
