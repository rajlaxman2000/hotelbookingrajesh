package com.hostel.action;

import java.util.List;

import com.hostel.model.RoomDTO;
import com.hostel.service.RoomService;
import com.opensymphony.xwork2.ActionSupport;

public class RoomAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String hostelName;
	
	private int hostelId;
	
	private int roomId;
	
	private String roomName;
	
	private String roomDescritpion;
	
	private RoomDTO roomDTO;
	
	private List<RoomDTO> rooms;
	
	private RoomService roomService;
		
	public String execute(){
		
		
		
		try {
			rooms= roomService.getRooms(hostelId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	
	
	/**
	 * @return the rooms
	 */
	public List<RoomDTO> getRooms() {
		return rooms;
	}



	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(List<RoomDTO> rooms) {
		this.rooms = rooms;
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
	 * @return the roomDescritpion
	 */
	public String getRoomDescritpion() {
		return roomDescritpion;
	}

	/**
	 * @param roomDescritpion the roomDescritpion to set
	 */
	public void setRoomDescritpion(String roomDescritpion) {
		this.roomDescritpion = roomDescritpion;
	}

	/**
	 * @return the roomDTO
	 */
	public RoomDTO getRoomDTO() {
		return roomDTO;
	}

	/**
	 * @param roomDTO the roomDTO to set
	 */
	public void setRoomDTO(RoomDTO roomDTO) {
		this.roomDTO = roomDTO;
	}


	/**
	 * @return the hostelName
	 */
	public String getHostelName() {
		return hostelName;
	}


	/**
	 * @param hostelName the hostelName to set
	 */
	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}


	/**
	 * @return the hostelId
	 */
	public int getHostelId() {
		return hostelId;
	}


	/**
	 * @param hostelId the hostelId to set
	 */
	public void setHostelId(int hostelId) {
		this.hostelId = hostelId;
	}
	
	
	

}
