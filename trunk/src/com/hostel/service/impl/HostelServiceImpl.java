package com.hostel.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hostel.dao.HostelDAO;
import com.hostel.model.HostelDTO;
import com.hostel.service.HostelService;
import com.hostel.service.RoomService;

public class HostelServiceImpl implements HostelService{

	private HostelDAO hostelDAO;
	
	private RoomService roomService;


	@Override
	public int insertHostel(HostelDTO hostelDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	@Override
	public List<HostelDTO> getHostels() throws Exception {
		ArrayList<HostelDTO> hostels; 
		try{
			hostels = (ArrayList<HostelDTO>) hostelDAO.getAllHostels();
		}catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
		return hostels;
	}
	
	

	@Override
	public HostelDTO getHostelDetails(int hostelId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the hostelDAO
	 */
	public HostelDAO getHostelDAO() {
		return hostelDAO;
	}

	/**
	 * @param hostelDAO the hostelDAO to set
	 */
	public void setHostelDAO(HostelDAO hostelDAO) {
		this.hostelDAO = hostelDAO;
	}


	
	

}
