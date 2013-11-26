package com.hostel.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hostel.dao.HostelDAO;
import com.hostel.model.HostelDTO;
import com.hostel.model.RoomDTO;
import com.hostel.service.HostelService;
import com.hostel.service.RoomService;

public class HostelServiceImpl implements HostelService{

	private HostelDAO hostelDAO;
	private RoomService roomService;
	
	@Override
	public int insertHostel(HostelDTO hostelDTO) throws Exception {
		int hostelId = hostelDAO.insertHostel(hostelDTO);
		
		hostelDTO.setHostelId(hostelId);
		int roomId;
		
		for(RoomDTO room : hostelDTO.getRooms()){
			roomId = roomService.insertUpdateRoom(room, hostelId);			
		}
		return hostelId;
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


	@Override
	public List<HostelDTO> searchHostelsByCity(String cityName)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
