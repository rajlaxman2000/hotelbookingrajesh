package com.hostel.model;

import java.sql.Date;

public class BedCostDTO implements Comparable<BedCostDTO> {
	
	private int bedId;
	private Date dateRange1;
	private Date dateRange2;
	private String dateRange1Str;
	private String dateRange2Str;
	private float bedCost;
	
	//These will be used while searching
	private String roomName;
	private int hostelId;
	private String hostelName;
	
	/**
	 * Comparing by bed Ids
	 */
	@Override
	public int compareTo(BedCostDTO o) {
		// TODO Auto-generated method stub
		return 0;
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
	 * @return the bedId
	 */
	public int getBedId() {
		return bedId;
	}
	/**
	 * @param bedId the bedId to set
	 */
	public void setBedId(int bedId) {
		this.bedId = bedId;
	}
	/**
	 * @return the dateRange1Str
	 */
	public String getDateRange1Str() {
		return dateRange1Str;
	}
	/**
	 * @param dateRange1Str the dateRange1Str to set
	 */
	public void setDateRange1Str(String dateRange1Str) {
		this.dateRange1Str = dateRange1Str;
	}
	/**
	 * @return the dateRange2Str
	 */
	public String getDateRange2Str() {
		return dateRange2Str;
	}
	/**
	 * @param dateRange2Str the dateRange2Str to set
	 */
	public void setDateRange2Str(String dateRange2Str) {
		this.dateRange2Str = dateRange2Str;
	}
	/**
	 * @return the dateRange1
	 */
	public Date getDateRange1() {
		return dateRange1;
	}
	/**
	 * @param dateRange1 the dateRange1 to set
	 */
	public void setDateRange1(Date dateRange1) {
		this.dateRange1 = dateRange1;
	}
	/**
	 * @return the dateRange2
	 */
	public Date getDateRange2() {
		return dateRange2;
	}
	/**
	 * @param dateRange2 the dateRange2 to set
	 */
	public void setDateRange2(Date dateRange2) {
		this.dateRange2 = dateRange2;
	}
	/**
	 * @return the bedCost
	 */
	public float getBedCost() {
		return bedCost;
	}
	/**
	 * @param bedCost the bedCost to set
	 */
	public void setBedCost(float bedCost) {
		this.bedCost = bedCost;
	}
	
	
	
}
