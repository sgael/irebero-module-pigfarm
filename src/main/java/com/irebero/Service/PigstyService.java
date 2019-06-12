package com.irebero.Service;

import java.util.List;

import com.irebero.Domain.District;
import com.irebero.Domain.PenTable;
import com.irebero.Domain.PigFarmingUsers;
import com.irebero.Domain.Pigsty;
import com.irebero.Domain.Province;
import com.irebero.Domain.Sector;

public interface PigstyService {
	
 Pigsty savepig(Pigsty pigsty);
 List<Pigsty> listall();
 Pigsty findById(Long id);
 Pigsty findOne(Long id);
 Pigsty findByOwner(String owner);
 void delete(Pigsty pigsty);
 void savepigsty(Pigsty pigsty,String owner);
 
 List<Sector>findSect();
 Pigsty findByid(Long id);
List<PigFarmingUsers>findowner();
List<PenTable>findpen();
}
