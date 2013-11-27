package com.hostel.commandline;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;



import com.hostel.model.BedCostDTO;

public class SearchResultDTO {
		
	private List<BedCostDTO> resultBedCosts;	
	private int noOfBeds;
	private Date startDate;
	private Date endDate;
	private int hostelId;
	private List<Integer> bedIs;
	
	/**
	 * @return the bedIs
	 */
	public List<Integer> getBedIs() {
		List<Integer> ids = new ArrayList<Integer>();
		setHostelId(this.resultBedCosts.get(0).getHostelId());
		for(BedCostDTO dto : this.resultBedCosts){
			ids.add(dto.getBedId());
		}
		
		return ids;
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
	 * @param bedIs the bedIs to set
	 */
	public void setBedIs(List<Integer> bedIs) {
		this.bedIs = bedIs;
	}

	/**
	 * @return the resultBedCosts
	 */
	public List<BedCostDTO> getResultBedCosts() {
		return resultBedCosts;
	}
	/**
	 * @param resultBedCosts the resultBedCosts to set
	 */
	public void setResultBedCosts(List<BedCostDTO> resultBedCosts) {
		this.resultBedCosts = resultBedCosts;
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
