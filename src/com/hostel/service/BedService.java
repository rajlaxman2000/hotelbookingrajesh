package com.hostel.service;

import java.util.List;

import com.hostel.model.BedDTO;

public interface BedService {
	
	public List<BedDTO> getBeds(int roomId);
	
	public BedDTO getBedDetails(int bedId);
	
	public boolean insertUpdateBed(BedDTO bedDTO);	

}
