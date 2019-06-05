package com.irebero.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irebero.Dao.PigDao;
import com.irebero.Domain.Pig;
import com.irebero.Service.PigService;

@Service
public class PigServiceImpl implements PigService {

	@Autowired
	PigDao pdao;

	@Override
	public Pig savepig(Pig pi) {

		return pdao.save(pi);
	}

}
