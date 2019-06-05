package com.irebero.Service;

import java.util.List;

import com.irebero.Domain.PenTable;

public interface PenService {

	List<PenTable>findpen();
	
	PenTable savepen(PenTable pens);
	boolean CheckCategoryExist(String cate);
	void delete(PenTable pe);
	PenTable findOne(Long id);
	PenTable findById(Long id);
}
