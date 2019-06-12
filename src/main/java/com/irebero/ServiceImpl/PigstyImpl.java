package com.irebero.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irebero.Dao.DistrictDao;
import com.irebero.Dao.OwnerDao;
import com.irebero.Dao.PenDao;
import com.irebero.Dao.PigstyDao;
import com.irebero.Dao.ProvinceDao;
import com.irebero.Dao.SectorDao;
import com.irebero.Domain.District;
import com.irebero.Domain.PenTable;
import com.irebero.Domain.PigFarmingUsers;
import com.irebero.Domain.Pigsty;
import com.irebero.Domain.Province;
import com.irebero.Domain.Sector;
import com.irebero.Service.PigstyService;

@Service
public class PigstyImpl implements PigstyService {

	@Autowired
	PigstyDao pigstyDao;
	@Autowired
	OwnerDao ownerDao;
	@Autowired
	ProvinceDao pdao;
	@Autowired
	DistrictDao disdao;
	@Autowired
	SectorDao secdao;
	@Autowired
	OwnerDao odao;
	@Autowired
	PenDao pedao;
	public Pigsty savepig(Pigsty pigsty) {
		return pigstyDao.save(pigsty);
	}
	@Override
	public List<Pigsty> listall(){
		return pigstyDao.findAll();
	}
	
	@Override
	public Pigsty findByOwner(String owner) {
		return pigstyDao.findByOwner(owner);
	}
	@Override
	public void delete(Pigsty pigsty) {
		pigstyDao.delete(pigsty);
	}
	@Override
	public Pigsty findById(Long id) {
		// TODO Auto-generated method stub
		return pigstyDao.findById(id).get();
	}
	@Override
	public Pigsty findOne(Long id) {
		// TODO Auto-generated method stub
		return pigstyDao.findByid(id);
	}
	@Override
	public void savepigsty(Pigsty pigsty, String owner) {
		
		PigFarmingUsers user=ownerDao.findByid(Long.parseLong(owner));
		pigsty.setOwner(user);
		pigstyDao.save(pigsty);
		
	}
	
	@Override
	public List<Sector> findSect() {
		// TODO Auto-generated method stub
		return secdao.findAll();
	}
	@Override
	public Pigsty findByid(Long id) {
		// TODO Auto-generated method stub
		return pigstyDao.findByid(id);
	}
	@Override
	public List<PigFarmingUsers> findowner() {
		// TODO Auto-generated method stub
		return odao.findAll();
	}
	@Override
	public List<PenTable> findpen() {
		// TODO Auto-generated method stub
		return pedao.findAll();
	}

}
