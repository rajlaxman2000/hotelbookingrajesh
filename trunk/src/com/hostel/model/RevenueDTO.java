package com.hostel.model;

public class RevenueDTO {
	
	private long totalOrdersRevenue;
	private long totalCancelAmount;
	private long totalGeneratedRevenue;
	/**
	 * @return the totalOrdersRevenue
	 */
	public long getTotalOrdersRevenue() {
		return totalOrdersRevenue;
	}
	/**
	 * @param totalOrdersRevenue the totalOrdersRevenue to set
	 */
	public void setTotalOrdersRevenue(long totalOrdersRevenue) {
		this.totalOrdersRevenue = totalOrdersRevenue;
	}
	/**
	 * @return the totalCancelAmount
	 */
	public long getTotalCancelAmount() {
		return totalCancelAmount;
	}
	/**
	 * @param totalCancelAmount the totalCancelAmount to set
	 */
	public void setTotalCancelAmount(long totalCancelAmount) {
		this.totalCancelAmount = totalCancelAmount;
	}
	/**
	 * @return the totalGeneratedRevenue
	 */
	public long getTotalGeneratedRevenue() {
		return totalGeneratedRevenue;
	}
	/**
	 * @param totalGeneratedRevenue the totalGeneratedRevenue to set
	 */
	public void setTotalGeneratedRevenue(long totalGeneratedRevenue) {
		this.totalGeneratedRevenue = totalGeneratedRevenue;
	}
	
	

}
