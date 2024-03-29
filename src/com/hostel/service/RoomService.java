package com.hostel.service;

import java.util.List;

import com.hostel.model.RoomDTO;

public interface RoomService {
	
	public List<RoomDTO> getRooms(int hostelId) throws Exception;
	
	public RoomDTO getRoomDetails(int roomId) throws Exception;
	
	public int insertUpdateRoom(RoomDTO roomDTO, int hostelId) throws Exception;

}
