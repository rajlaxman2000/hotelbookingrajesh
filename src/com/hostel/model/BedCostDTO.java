package com.hostel.model;

import java.util.Date;

public class BedCostDTO {
	
	private Date dateRange1;
	private Date dateRange2;
	private float bedCost;
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
