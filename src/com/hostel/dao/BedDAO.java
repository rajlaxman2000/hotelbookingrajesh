package com.hostel.dao;

import java.util.List;

import com.hostel.model.BedDTO;

public interface BedDAO {
	
	public List<BedDTO> getBedsByRoomId(int roomId) throws Exception;
	
	public BedDTO getBedDetailsByBedId(int bedId);
	
	public boolean updateBed(BedDTO bedDTO);
	
	public boolean insertBed(BedDTO bedDTO);
	
	/*Put bed cost default value as 0 and bedAvailablity as Y by default
	 * So while iserting if we don't pass means tru nut u can also say no fo rthe availablity */
	public final String getBedsQuery="select bed_id, bed_name, price, avaliable from bed where room_id=:roomId";
	
	public final String getBedDetailsQuery="select bed_id, bed_name, room_id from bed where bed_id=:bed_id";
	
	public final String updateBedQuery="update bed set bed_name=:bedName, bed_cost=:bedCost, bed_available=:bedAvailable where bed_id=:bedId";
	
	public final String insertBedQuery="insert into bed (bed_name, room_id) values (:bedName,:roomId)";

}
