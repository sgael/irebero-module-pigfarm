package com.irebero.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irebero.Dao.PenDao;
import com.irebero.Domain.PenTable;
import com.irebero.Service.PenService;

@Service
public class PenServiceImp implements PenService{

	@Autowired
	PenDao pdao; 
	@Override
	public List<PenTable> findpen() {
		// TODO Auto-generated method stub
		return pdao.findAll();
	}

	@Override
	public PenTable savepen(PenTable pens) {
		// TODO Auto-generated method stub
		return pdao.save(pens);
	}

	@Override
	public boolean CheckCategoryExist(String cate) {
		// TODO Auto-generated method stub
		if(pdao.findByCategory(cate)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void delete(PenTable pe) {
		// TODO Auto-generated method stub
		pdao.delete(pe);
	}

	@Override
	public PenTable findOne(Long id) {
		// TODO Auto-generated method stub
		return pdao.findByid(id);
	}

	@Override
	public PenTable findById(Long id) {
		// TODO Auto-generated method stub
		return pdao.findByid(id);
	}

	@Override
	public PenTable findByCategory(String ca) {
		return pdao.findByCategory(ca);
	}
	

}
