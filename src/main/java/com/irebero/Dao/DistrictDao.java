package com.irebero.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.irebero.Domain.District;
import com.irebero.Domain.Province;

public interface DistrictDao extends CrudRepository<District, Long>{
	@Query("from District where province = province")
	List<District> findAllByProvince(Province province);

District findByid(Long id);
}
