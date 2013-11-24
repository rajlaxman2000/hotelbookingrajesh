package com.hostel.dao;

import java.util.List;

import com.hostel.model.BedCostDTO;
import com.hostel.model.BedDTO;

public interface BedCostDAO {

public List<BedDTO> getBedsByRoomId(int roomId) throws Exception;
	
	public List<BedCostDTO> getBedCostDetailsByBedId(int bedId) throws Exception;
	
	public boolean insertBedCosts(List <BedCostDTO> bedCostDTOs, int bedId) throws Exception;
		
	public final String getBedcostsQuery="select bed_id, date_range1, date_range2, bed_cost from bed_cost where bed_id=:bedId";
	//insert into sample values (1,20,50),(2,30,60),(3,22,80)
	public final String insertBedCostsQuery="insert into bed_cost (bed_id, date1, date2, bed_cost) values ";

}
