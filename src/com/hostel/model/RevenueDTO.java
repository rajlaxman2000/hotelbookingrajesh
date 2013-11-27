package com.hostel.model;

public class RevenueDTO {
	
	private float totalOrdersRevenue;
	private float totalCancelAmount;
	private float totalGeneratedRevenue;
	/**
	 * @return the totalOrdersRevenue
	 */
	public float getTotalOrdersRevenue() {
		return totalOrdersRevenue;
	}
	/**
	 * @param totalOrdersRevenue the totalOrdersRevenue to set
	 */
	public void setTotalOrdersRevenue(float totalOrdersRevenue) {
		this.totalOrdersRevenue = totalOrdersRevenue;
	}
	/**
	 * @return the totalCancelAmount
	 */
	public float getTotalCancelAmount() {
		return totalCancelAmount;
	}
	/**
	 * @param totalCancelAmount the totalCancelAmount to set
	 */
	public void setTotalCancelAmount(float totalCancelAmount) {
		this.totalCancelAmount = totalCancelAmount;
	}
	/**
	 * @return the totalGeneratedRevenue
	 */
	public float getTotalGeneratedRevenue() {
		return totalGeneratedRevenue;
	}
	/**
	 * @param totalGeneratedRevenue the totalGeneratedRevenue to set
	 */
	public void setTotalGeneratedRevenue(float totalGeneratedRevenue) {
		this.totalGeneratedRevenue = totalGeneratedRevenue;
	}
	
}
