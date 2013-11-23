package com.hostel.service.impl;

import java.util.List;

import com.hostel.dao.BedDAO;
import com.hostel.dao.RoomDAO;
import com.hostel.model.BedDTO;
import com.hostel.model.RoomDTO;
import com.hostel.service.RoomService;

public class RoomServiceImpl implements RoomService{
	
	private RoomDAO roomDAO;
	
	private BedDAO bedDAO;

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

	@Override
	public boolean insertUpdateRoom(RoomDTO roomDTO) {
		// TODO Auto-generated method stub
		return false;
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
	
	

}
