package com.hostel.service;

import java.sql.Date;
import java.util.List;

import com.hostel.model.BedCostDTO;
import com.hostel.model.BedDTO;

public interface BedService {
	
	public List<BedDTO> getBeds(int roomId) throws Exception;
	
	public BedDTO getBedDetails(int bedId)throws Exception;
	
	public int insertUpdateBed(BedDTO bedDTO, int roomId) throws Exception;	
	
	public List<BedCostDTO> getBedCostsByHostelIdDateRanges(int hostelId, Date date1, Date date2) throws Exception;

}
