package com.hostel.model;

import java.util.List;

public class HostelDTO {
	
	private int hostelId;
	private String hostelName;
	private AddressDTO hostelAddDto;
	private String hostelCity;
	private String hostelCountry;	
	private int orderCancellationDaysLimit;
	private int cancellationFeePercant;
	private List<RoomDTO> rooms;
	
	
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
	 * @return the hostelAddDto
	 */
	public AddressDTO getHostelAddDto() {
		return hostelAddDto;
	}
	/**
	 * @param hostelAddDto the hostelAddDto to set
	 */
	public void setHostelAddDto(AddressDTO hostelAddDto) {
		this.hostelAddDto = hostelAddDto;
	}
	/**
	 * @return the hostelCity
	 */
	public String getHostelCity() {
		return hostelCity;
	}
	/**
	 * @param hostelCity the hostelCity to set
	 */
	public void setHostelCity(String hostelCity) {
		this.hostelCity = hostelCity;
	}
	/**
	 * @return the hostelCountry
	 */
	public String getHostelCountry() {
		return hostelCountry;
	}
	/**
	 * @param hostelCountry the hostelCountry to set
	 */
	public void setHostelCountry(String hostelCountry) {
		this.hostelCountry = hostelCountry;
	}

}
