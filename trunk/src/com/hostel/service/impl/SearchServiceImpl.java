package com.hostel.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.hostel.model.BedCostDTO;
import com.hostel.model.BedDTO;
import com.hostel.model.HostelDTO;
import com.hostel.model.RoomDTO;
import com.hostel.service.BedService;
import com.hostel.service.HostelService;
import com.hostel.service.RoomService;
import com.hostel.service.SearchService;

public class SearchServiceImpl implements SearchService {
	HostelService hostelService;
	RoomService roomService;
	BedService bedService;
	
	@Override
	public List<BedCostDTO> searchByCriteria(String cityName, Date startDate, Date endDate, int noOfBeds) throws Exception {
		List<BedCostDTO> availbleBedCosts=null;
		List<BedCostDTO> actualBedCosts = null;
		List<HostelDTO> hostels;
		if(cityName !=null && cityName.length()>0){
			hostels = hostelService.searchHostelsByCity(cityName);
		}else{
			hostels = hostelService.getHostels();	
		}
		if(hostels != null && hostels.size()>0){
			for(HostelDTO hostelDTO : hostels){
				actualBedCosts = bedService.getBedCostsByHostelIdDateRanges(hostelDTO.getHostelId(), startDate, endDate);
			}
		}
		
		/*Now among them take each bed and check it is available by checking the orders
		 * The list might contain same bed ids with different costDTOs, So plan is to get the each bedId List and send it to the bleow mthod 
		 * which will first sort by start date and then find min max and then check with that Is there any order booked fo rthat date or not
		 * So the below method will return true if it is avaiable so we just need to add that bedCostDTO for that id to available bedCostDTOS  
		 */
		int initialBedId = actualBedCosts.get(0).getBedId();
		List<BedCostDTO> tmpBedCostDTOs = new ArrayList<BedCostDTO>();
		for(int i=1; i<actualBedCosts.size();i++){
			if(i == actualBedCosts.size()-1){
				
			}else{
				
			}
		}
		
		
		
		
		Date minDate,maxDate;
		
		/*
		 * IF tmpStartDate is small than startDate -1, equal 0, if tmpStartDate is bigger than startDate 1
		 * The below logic will pull all the actual beds with in the given date range.
		 * In next step we need to chek whether  
		 */
		if(actualBedCosts!=null && actualBedCosts.size()>0){
			Date tmpStartDate,tmpEndDate;
			int i;
				tmpStartDate = actualBedCosts.get(0).getDateRange1();				
				i  = tmpStartDate.compareTo(startDate);
				if(i>=0){
					minDate = tmpStartDate;
			}else{
					minDate = startDate;
				}
				tmpEndDate =actualBedCosts.get(actualBedCosts.size()-1).getDateRange2();
				i =tmpEndDate.compareTo(endDate);
				if(i>=0){
					maxDate =endDate;
				}else{
					maxDate = tmpEndDate;
				}
		}
		
		return availbleBedCosts;
	}
	
	public boolean CheckActualBedAvailability(Date actualStartDate, Date actualEndDate,Date tmpStartDate,Date tmpEndDate){
		Date minDate,maxDate;
		/*
		 * IF tmpStartDate is small than startDate -1, equal 0, if tmpStartDate is bigger than startDate 1
		 * The below logic will pull all the actual beds with in the given date range.
		 * In next step we need to chek whether  
		 */
		/*
		if(actualBedCosts!=null && actualBedCosts.size()>0){
			Date tmpStartDate,tmpEndDate;
			int i;
				tmpStartDate = actualBedCosts.get(0).getDateRange1();				
				i  = tmpStartDate.compareTo(startDate);
				if(i>=0){
					minDate = tmpStartDate;
			}else{
					minDate = startDate;
				}
				tmpEndDate =actualBedCosts.get(actualBedCosts.size()-1).getDateRange2();
				i =tmpEndDate.compareTo(endDate);
				if(i>=0){
					maxDate =endDate;
				}else{
					maxDate = tmpEndDate;
				}
		}*/
		return false;
	}
	
	
	
	

}
