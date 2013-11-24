package com.hostel.service.impl;

import java.util.List;

import com.hostel.dao.BedCostDAO;
import com.hostel.dao.BedDAO;
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

	@Override
	public BedDTO getBedDetails(int bedId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUpdateBed(BedDTO bedDTO, int roomId) throws Exception {
		int bedId;		
		bedId  = bedDAO.insertBed(bedDTO, roomId);
		bedDTO.setBedId(bedId);
			bedCostDAO.insertBedCosts(bedDTO.getCostDTOs(), bedId);
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
