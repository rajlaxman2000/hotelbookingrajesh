package com.hostel.dao;

import java.sql.Date;
import java.util.List;

import com.hostel.model.BedCostDTO;
import com.hostel.model.BedDTO;

public interface BedCostDAO {

	public List<BedDTO> getBedsByRoomId(int roomId) throws Exception;
	
	public List<BedCostDTO> getBedCostDetailsByBedId(int bedId) throws Exception;
	
	//public boolean insertBedCosts(List <BedCostDTO> bedCostDTOs, int bedId) throws Exception;
	
	public boolean insertBedCost(BedCostDTO bedCostDTO, int bedId) throws Exception;
	
	public List<BedCostDTO> getBedCostDTOsByForSearch(int hostelId) throws Exception;
	
	public List<BedCostDTO> getBedCostDTOsByDatesForSearch(int hostelId,Date date1, Date date2) throws Exception;
	
	public final String getBedcostsQuery="select bed_id, date_range1, date_range2, bed_cost from bed_cost where bed_id=:bedId";
	//insert into sample values (1,20,50),(2,30,60),(3,22,80)
	public final String insertBedCostsQuery="insert into bed_cost (bed_id, date_range1, date_range2, bed_cost) values ";

	public final String insertBedCostQuery="insert into bed_cost (bed_id, date_range1, date_range2, bed_cost) values (:bedId,:dateRange1,:dateRange2,:bedCost) ";
	
	public final String searchBedCostForSearchQuery = "select r.room_id,r.room_name,bc.bed_id, bc.date_range1,bc.date_range2,bc.bed_cost from bed_cost bc" +
			"inner join bed b  on bc.bed_id = b.bed_id " +
			" inner join room r on r.room_id = b.room_id " +
			"inner join hostel h on h.hostel_id = r.hostel_id " +
			" where h.hostel_id:=hostelId";
	
}
