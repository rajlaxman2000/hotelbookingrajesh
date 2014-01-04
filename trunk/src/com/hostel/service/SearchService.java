package com.hostel.service;

import java.sql.Date;
import java.util.List;

import com.hostel.model.BedCostDTO;


public interface SearchService {
	
	
	public List<BedCostDTO> searchByCriteria(String city, Date startDate, Date endDate, int noOfBeds) throws Exception;  
	
	public List<BedCostDTO> OccupiedBedCostDTOs(String cityName, Date startDate, Date endDate) throws Exception;
	
	
	
}
