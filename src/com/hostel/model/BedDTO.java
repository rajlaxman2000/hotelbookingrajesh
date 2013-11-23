package com.hostel.model;

import java.util.List;

public class BedDTO {

	private int bedId;
	private String bedName;
	private List<BedCostDTO> costDTOs;
	
	
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
	/**
	 * @return the costDTOs
	 */
	public List<BedCostDTO> getCostDTOs() {
		return costDTOs;
	}
	/**
	 * @param costDTOs the costDTOs to set
	 */
	public void setCostDTOs(List<BedCostDTO> costDTOs) {
		this.costDTOs = costDTOs;
	}
	
}
