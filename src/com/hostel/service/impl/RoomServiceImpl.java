package com.hostel.service.impl;

import java.util.List;

import com.hostel.dao.BedDAO;
import com.hostel.dao.RoomDAO;
import com.hostel.model.BedDTO;
import com.hostel.model.RoomDTO;
import com.hostel.service.BedService;
import com.hostel.service.RoomService;

public class RoomServiceImpl implements RoomService{
	
	private RoomDAO roomDAO;
	
	private BedDAO bedDAO;
	
	private BedService bedService;
	
	@Override
	public int insertUpdateRoom(RoomDTO roomDTO, int hostelId) throws Exception {
		
		int roomId;
		try {
			roomId = roomDAO.InsertRoom(roomDTO,hostelId);
			for(BedDTO bed : roomDTO.getBeds()){
				bedService.insertUpdateBed(bed, roomId);
			}	
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
		return roomId;
	}
	
	@Override
	public List<RoomDTO> getRooms(int hostelId) throws Exception{
		List<RoomDTO> rooms;
		List<BedDTO> beds;	
		
		try {
			rooms = roomDAO.getRoomsbyHostelId(hostelId);		
			if(rooms.size()>0){
				for (RoomDTO roomDTO : rooms) {
					beds = bedDAO.getBedsByRoomId(roomDTO.getRoomId());
					roomDTO.setBeds(beds);
				}			
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
		return rooms;		
	}

	@Override
	public RoomDTO getRoomDetails(int roomId) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * @return the roomDAO
	 */
	public RoomDAO getRoomDAO() {
		return roomDAO;
	}

	/**
	 * @param roomDAO the roomDAO to set
	 */
	public void setRoomDAO(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
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

	
	
	

}
