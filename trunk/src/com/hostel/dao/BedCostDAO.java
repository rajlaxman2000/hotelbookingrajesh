package com.hostel.dao;

import java.util.List;

import com.hostel.model.BedCostDTO;
import com.hostel.model.BedDTO;

public interface BedCostDAO {

public List<BedDTO> getBedsByRoomId(int roomId) throws Exception;
	
	public List<BedCostDTO> getBedCostDetailsByBedId(int bedId);
	
	public boolean insertBedCost(BedCostDTO bedCostDTO);
		
	public final String getBedcostsQuery="select bed_id, date_range1, date_range2, price from bed_cost where bed_id=:bedId";
	
	public final String insertBedCostsQuery="insert into bed values (";

}
