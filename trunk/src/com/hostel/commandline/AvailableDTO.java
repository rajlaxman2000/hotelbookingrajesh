package com.hostel.commandline;

import java.util.Date;

public class AvailableDTO implements Comparable<AvailableDTO>{
	private Date date;
	private String roomName;
	private String bedName;
	private float price;
	
	
	@Override
	public int compareTo(AvailableDTO dto) {
		
		Date date2 = dto.getDate();		
		return this.getDate().compareTo(date2);
	}
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @return the baedName
	 */

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @return the badName
	 */

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the bedName
	 */
	public String getBedName() {
		return bedName;
	}
	/**
	 * @param bedName the bedName to set
	 */
	public void setBedName(String bedName) {
		this.bedName = bedName;
	}

	
	
}
