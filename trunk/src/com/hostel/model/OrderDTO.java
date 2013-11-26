package com.hostel.model;

import java.util.Date;
import java.util.List;

public class OrderDTO {
	
	private int orderId;
	private int customerId;	
	private int hostelId;	
	private float orderCost;
	private float orderCancelAmt;
	private Date orderCancelDate;
	private Date OrderPlcdDate;
	private Date OrderStartDate;
	private Date OrderEndDate;	
	private List<OrderBedDTO> orderBeds;
	
	//for rendering 
	private int noOfBeds;
	private String hostelName;
	private String customerName;
	
	
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
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the noOfBeds
	 */
	public int getNoOfBeds() {
		return noOfBeds;
	}
	/**
	 * @param noOfBeds the noOfBeds to set
	 */
	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
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
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	 * @return the orderCost
	 */
	public float getOrderCost() {
		return orderCost;
	}
	/**
	 * @param orderCost the orderCost to set
	 */
	public void setOrderCost(float orderCost) {
		this.orderCost = orderCost;
	}
	/**
	 * @return the orderCancelAmt
	 */
	public float getOrderCancelAmt() {
		return orderCancelAmt;
	}
	/**
	 * @param orderCancelAmt the orderCancelAmt to set
	 */
	public void setOrderCancelAmt(float orderCancelAmt) {
		this.orderCancelAmt = orderCancelAmt;
	}
	/**
	 * @return the orderCancelDate
	 */
	public Date getOrderCancelDate() {
		return orderCancelDate;
	}
	/**
	 * @param orderCancelDate the orderCancelDate to set
	 */
	public void setOrderCancelDate(Date orderCancelDate) {
		this.orderCancelDate = orderCancelDate;
	}
	/**
	 * @return the orderPlcdDate
	 */
	public Date getOrderPlcdDate() {
		return OrderPlcdDate;
	}
	/**
	 * @param orderPlcdDate the orderPlcdDate to set
	 */
	public void setOrderPlcdDate(Date orderPlcdDate) {
		OrderPlcdDate = orderPlcdDate;
	}
	/**
	 * @return the orderStartDate
	 */
	public Date getOrderStartDate() {
		return OrderStartDate;
	}
	/**
	 * @param orderStartDate the orderStartDate to set
	 */
	public void setOrderStartDate(Date orderStartDate) {
		OrderStartDate = orderStartDate;
	}
	/**
	 * @return the orderEndDate
	 */
	public Date getOrderEndDate() {
		return OrderEndDate;
	}
	/**
	 * @param orderEndDate the orderEndDate to set
	 */
	public void setOrderEndDate(Date orderEndDate) {
		OrderEndDate = orderEndDate;
	}
	/**
	 * @return the orderBeds
	 */
	public List<OrderBedDTO> getOrderBeds() {
		return orderBeds;
	}
	/**
	 * @param orderBeds the orderBeds to set
	 */
	public void setOrderBeds(List<OrderBedDTO> orderBeds) {
		this.orderBeds = orderBeds;
	}

	
	

}
