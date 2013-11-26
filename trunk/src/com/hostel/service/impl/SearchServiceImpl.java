package com.hostel.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hostel.model.BedCostDTO;
import com.hostel.model.HostelDTO;
import com.hostel.model.OrderDTO;
import com.hostel.service.BedService;
import com.hostel.service.HostelService;
import com.hostel.service.OrderService;
import com.hostel.service.RoomService;
import com.hostel.service.SearchService;

public class SearchServiceImpl implements SearchService {
	HostelService hostelService;
	RoomService roomService;
	BedService bedService;
	OrderService orderService;
	
	
	
	
	@Override
	public List<BedCostDTO> searchByCriteria(String cityName, Date startDate, Date endDate, int noOfBeds) throws Exception {
		List<BedCostDTO> availbleBedCosts= new ArrayList<BedCostDTO>();
		List<BedCostDTO> actualBedCosts = new ArrayList<BedCostDTO>();
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
		
		if(actualBedCosts!=null && actualBedCosts.size()>0){
			/*Now among them take each bed and check it is available by checking the orders
			 * The list might contain same bed ids with different costDTOs, So plan is to get the each bedId List and send it to the bleow mthod 
			 * which will first sort by start date and then find min max and then check with that Is there any order booked fo rthat date or not
			 * So the below method will return true if it is avaiable so we just need to add that bedCostDTO for that id to available bedCostDTOS  
			 */
			int initialBedId = actualBedCosts.get(0).getBedId();
			List<BedCostDTO> tmpBedCostDTOs = new ArrayList<BedCostDTO>();
			Map<Integer, List<BedCostDTO>> bedCostsMapById = new HashMap<Integer, List<BedCostDTO>>();  
			for(int i=0; i<actualBedCosts.size();i++){			
				if(initialBedId!=actualBedCosts.get(i).getBedId()){				
					bedCostsMapById.put(initialBedId, new ArrayList<BedCostDTO>(tmpBedCostDTOs));
					tmpBedCostDTOs.clear();
					tmpBedCostDTOs.add(actualBedCosts.get(i));
					initialBedId = actualBedCosts.get(i).getBedId();
				}else{
					tmpBedCostDTOs.add(actualBedCosts.get(i));
				}
			}
			
			// Check whether the beds we got sufficient numbers or not			
			if(bedCostsMapById.entrySet().size()>= noOfBeds){
				for(Map.Entry<Integer, List<BedCostDTO>> entry: bedCostsMapById.entrySet() ){			
					List<BedCostDTO> dtos = entry.getValue();
					//Check if start & end date empty the we need to take bed DateRanges as startDate and end date
					if(startDate == null & endDate==null ){
						startDate = dtos.get(0).getDateRange1();
						endDate =  dtos.get(dtos.size()-1).getDateRange2();
					}
					boolean result = CheckActualBedAvailability(dtos,startDate,endDate);
					if(result){
						availbleBedCosts.addAll(dtos);
					}
				}
			}	
		}	
		
		return (availbleBedCosts!=null && availbleBedCosts.size()>0)?availbleBedCosts:null;
	}
	
	/*
	 * IF tmpStartDate is small than startDate -1, equal 0, if tmpStartDate is bigger than startDate 1
	 * The below logic will pull all the actual beds with in the given date range.
	 * In next step we need to chek whether  
	 */
	
	public boolean CheckActualBedAvailability(List<BedCostDTO> bedCosts, Date startDate, Date endDate) throws Exception {
		
		Date minDate=null,maxDate=null;
		
		if(bedCosts!=null && bedCosts.size()>0){
			Date tmpStartDate,tmpEndDate;
			int i;
			tmpStartDate = bedCosts.get(0).getDateRange1();				
			i  = tmpStartDate.compareTo(startDate);
			minDate = (i>=0)?tmpStartDate:startDate;
			tmpEndDate =bedCosts.get(bedCosts.size()-1).getDateRange2();
			i =tmpEndDate.compareTo(endDate);
			maxDate = (i>=0)?endDate:tmpEndDate;
			/*
			if(i>=0){
				minDate = tmpStartDate;
			}else{
					minDate = startDate;
			}
			if(i>=0){
				maxDate =endDate;
			}else{
				maxDate = tmpEndDate;
			*/
		}
		
		List<OrderDTO> orders  = orderService.getOrdersByHostelBedDateRange(bedCosts.get(0).getHostelId(), bedCosts.get(0).getBedId(), minDate, maxDate);
		boolean result=false;
		if(orders==null || orders.size()==0)
			result = true;
		
		return result;
	}

	/**
	 * @return the hostelService
	 */
	public HostelService getHostelService() {
		return hostelService;
	}

	/**
	 * @param hostelService the hostelService to set
	 */
	public void setHostelService(HostelService hostelService) {
		this.hostelService = hostelService;
	}

	/**
	 * @return the roomService
	 */
	public RoomService getRoomService() {
		return roomService;
	}

	/**
	 * @param roomService the roomService to set
	 */
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	/**
	 * @return the bedService
	 */
	public BedService getBedService() {
		return bedService;
	}

	/**
	 * @param bedService the bedService to set
	 */
	public void setBedService(BedService bedService) {
		this.bedService = bedService;
	}

	/**
	 * @return the orderService
	 */
	public OrderService getOrderService() {
		return orderService;
	}

	/**
	 * @param orderService the orderService to set
	 */
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	
	

}
