package com.hostel.service.impl;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.hostel.dao.BedCostDAO;
import com.hostel.dao.BedDAO;
import com.hostel.model.BedCostDTO;
import com.hostel.model.BedDTO;
import com.hostel.service.BedService;

public class BedServiceImpl implements BedService {

	private BedDAO bedDAO;
	
	private BedCostDAO bedCostDAO;
	
	
	@Override
	public List<BedDTO> getBeds(int roomId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<BedCostDTO> getBedCostsByHostelIdDateRanges(int hostelId, Date date1, Date date2) throws Exception{
		List<BedCostDTO> availBedCosts = null;
		
		if(hostelId!=0 && date1!=null && date2 != null ){
			availBedCosts = bedCostDAO.getBedCostDTOsByDatesForSearch(hostelId, date1, date2);
		}else if(hostelId!=0){
			availBedCosts = bedCostDAO.getBedCostDTOsByForSearch(hostelId);
		}
		
		return availBedCosts;
	}	
	@Override
	public BedDTO getBedDetails(int bedId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@SuppressWarnings("deprecation")
	@Override
	public int insertUpdateBed(BedDTO bedDTO, int roomId) throws Exception {
		int bedId;		
		bedId  = bedDAO.insertBed(bedDTO, roomId);
		bedDTO.setBedId(bedId);
		Date date2;
		int year, month, day;
		for (int i=0;i<bedDTO.getCostDTOs().size();i++){
			if(i == bedDTO.getCostDTOs().size()-1 ){
				year = bedDTO.getCostDTOs().get(i).getDateRange1().getYear();
				month = bedDTO.getCostDTOs().get(i).getDateRange1().getMonth();
				day = bedDTO.getCostDTOs().get(i).getDateRange1().getDate();
				date2 = new Date(year, month+1,day-1);
			}else{
				year = bedDTO.getCostDTOs().get(i+1).getDateRange1().getYear();
				month = bedDTO.getCostDTOs().get(i+1).getDateRange1().getMonth();
				day = bedDTO.getCostDTOs().get(i+1).getDateRange1().getDate();
				date2 = new Date(year,month,day-1);
			}	
			bedDTO.getCostDTOs().get(i).setDateRange2(date2);
			bedCostDAO.insertBedCost(bedDTO.getCostDTOs().get(i), bedId);
		}
		return bedId;
	}
	
	/**
	 * @return the bedDAO
	 */
	public BedDAO getBedDAO() {
		return bedDAO;
	}

	/**
	 * @param bedDAO the bedDAO to set
	 */
	public void setBedDAO(BedDAO bedDAO) {
		this.bedDAO = bedDAO;
	}

	/**
	 * @return the bedCostDAO
	 */
	public BedCostDAO getBedCostDAO() {
		return bedCostDAO;
	}

	/**
	 * @param bedCostDAO the bedCostDAO to set
	 */
	public void setBedCostDAO(BedCostDAO bedCostDAO) {
		this.bedCostDAO = bedCostDAO;
	}



}
