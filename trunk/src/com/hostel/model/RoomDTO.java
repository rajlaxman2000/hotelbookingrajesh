package com.hostel.model;

import java.util.List;

public class RoomDTO {
	
	private int roomId;
	private String roomName;
	private List<BedDTO> beds;
	
	/**
	 * @return the roomId
	 */
	public int getRoomId() {
		return roomId;
	}
	/**
	 * @param roomId the roomId to set
	 */
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	/**
	 * @return the roomName
	 */
	public String getRoomName() {
		return roomName;
	}
	/**
	 * @param roomName the roomName to set
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	/**
	 * @return the beds
	 */
	public List<BedDTO> getBeds() {
		return beds;
	}
	/**
	 * @param beds the beds to set
	 */
	public void setBeds(List<BedDTO> beds) {
		this.beds = beds;
	}
	

}
