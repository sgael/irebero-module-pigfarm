package com.irebero.Service;

import java.util.List;

import com.irebero.Domain.District;
import com.irebero.Domain.Province;

public interface DistrictService {
	void save(District district);
	List<District> findAllByProvince(Province province);
	District findById(Long id);
}
