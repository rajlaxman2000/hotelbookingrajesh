package com.hostel.model;

import java.util.List;

public class HostelDTO {
	
	private int hostelId;
	private String hostelName;	
	private String adrStreet;
	private String adrCity;
	private String adrState;
	private String adrPostalCode;
	private String adrCountry;
	private String phone;
	private String email;
	private String facebook;
	private String web;
	private int orderCancellationHoursLimit;
	private int cancellationFeePercant;
	private String checkInTime;
	private String checkOutTime;
	private String alcohol;
	private String smoking;	

	private List<RoomDTO> rooms;
	
	
	
	
	
	
	/**
	 * @return the alcohol
	 */
	public String getAlcohol() {
		return alcohol;
	}
	/**
	 * @param alcohol the alcohol to set
	 */
	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}
	/**
	 * @return the smoking
	 */
	public String getSmoking() {
		return smoking;
	}
	/**
	 * @param smoking the smoking to set
	 */
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	/**
	 * @return the adrStreet
	 */
	public String getAdrStreet() {
		return adrStreet;
	}
	/**
	 * @param adrStreet the adrStreet to set
	 */
	public void setAdrStreet(String adrStreet) {
		this.adrStreet = adrStreet;
	}
	/**
	 * @return the adrCity
	 */
	public String getAdrCity() {
		return adrCity;
	}
	/**
	 * @param adrCity the adrCity to set
	 */
	public void setAdrCity(String adrCity) {
		this.adrCity = adrCity;
	}
	/**
	 * @return the adrState
	 */
	public String getAdrState() {
		return adrState;
	}
	/**
	 * @param adrState the adrState to set
	 */
	public void setAdrState(String adrState) {
		this.adrState = adrState;
	}
	/**
	 * @return the adrPostalCode
	 */
	public String getAdrPostalCode() {
		return adrPostalCode;
	}
	/**
	 * @param adrPostalCode the adrPostalCode to set
	 */
	public void setAdrPostalCode(String adrPostalCode) {
		this.adrPostalCode = adrPostalCode;
	}
	/**
	 * @return the adrCountry
	 */
	public String getAdrCountry() {
		return adrCountry;
	}
	/**
	 * @param adrCountry the adrCountry to set
	 */
	public void setAdrCountry(String adrCountry) {
		this.adrCountry = adrCountry;
	}
	/**
	 * @return the checkInTime
	 */
	public String getCheckInTime() {
		return checkInTime;
	}
	/**
	 * @param checkInTime the checkInTime to set
	 */
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	/**
	 * @return the checkOutTime
	 */
	public String getCheckOutTime() {
		return checkOutTime;
	}
	/**
	 * @param checkOutTime the checkOutTime to set
	 */
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
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
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the facebook
	 */
	public String getFacebook() {
		return facebook;
	}
	/**
	 * @param facebook the facebook to set
	 */
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	/**
	 * @return the web
	 */
	public String getWeb() {
		return web;
	}
	/**
	 * @param web the web to set
	 */
	public void setWeb(String web) {
		this.web = web;
	}
	/**
	 * @return the orderCancellationHoursLimit
	 */
	public int getOrderCancellationHoursLimit() {
		return orderCancellationHoursLimit;
	}
	/**
	 * @param orderCancellationHoursLimit the orderCancellationHoursLimit to set
	 */
	public void setOrderCancellationHoursLimit(int orderCancellationHoursLimit) {
		this.orderCancellationHoursLimit = orderCancellationHoursLimit;
	}
	/**
	 * @return the cancellationFeePercant
	 */
	public int getCancellationFeePercant() {
		return cancellationFeePercant;
	}
	/**
	 * @param cancellationFeePercant the cancellationFeePercant to set
	 */
	public void setCancellationFeePercant(int cancellationFeePercant) {
		this.cancellationFeePercant = cancellationFeePercant;
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
	
	
	
}
