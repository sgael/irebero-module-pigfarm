package com.irebero.Service;

import java.util.List;

import com.irebero.Domain.PigFarmingUsers;

public interface OwnerService {

	PigFarmingUsers saveowner(PigFarmingUsers owners);
	List<PigFarmingUsers>findowner();
	PigFarmingUsers findOne(Long id);
	void delete (PigFarmingUsers owner);
	PigFarmingUsers findById(Long id);
	PigFarmingUsers findByNames(String names);
}
