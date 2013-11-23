package com.hostel.dao;

import java.util.List;

import com.hostel.model.RoomDTO;

public interface RoomDAO {
	
	public List<RoomDTO> getRoomsbyHostelId(int hostelId) throws Exception;
	
	public RoomDTO getRoomDetailsById(int roomId);
	
	public boolean InsertRoom(RoomDTO roomDTO);
	
	public boolean UpdateRoom(RoomDTO roomDTO);
	
	public final String getRoomsQuery="select room_id, room_name from room where hostel_id=:hostelId";
	
	public final String getRoomDetailByRoomIdQuery="select room_id, room_name from room where room_id=roomId";
	
	public final String updateRoomQuery="update room set room_name=:roomName, room_descriotion=roomDescription where room_id=:roomId";
	
	public final String insertRoomQuery="insert into room (room_name, room_descripton, hostel_id) vlaues (:roomName, :roomDescription,:hostel_id)";

}
