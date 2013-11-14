package com.hostel.model;

import java.util.Date;

public class OrderBedDTO {
	private int orderBedId;
	private int orderId;
	private int bedId;
	private Date startDate;
	private Date endDate;
	/**
	 * @return the orderBedId
	 */
	public int getOrderBedId() {
		return orderBedId;
	}
	/**
	 * @param orderBedId the orderBedId to set
	 */
	public void setOrderBedId(int orderBedId) {
		this.orderBedId = orderBedId;
	}
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
