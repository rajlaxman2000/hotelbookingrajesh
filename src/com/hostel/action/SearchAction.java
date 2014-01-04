package com.hostel.action;

import java.sql.Date;
import java.util.List;

import com.hostel.model.BedCostDTO;
import com.hostel.service.SearchService;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {
	
	private SearchService searchService;
	
	String city;
	Date startDate;
	Date endDate;
	int noOfBeds;
	
	public String execute() {
		
		try {
			beds = searchService.searchByCriteria(city, startDate, endDate, noOfBeds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
		 
	 }
	
	/**
	 * @return the searchService
	 */
	public SearchService getSearchService() {
		return searchService;
	}

	/**
	 * @param searchService the searchService to set
	 */
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
	List<BedCostDTO> beds;
	
	/**
	 * @return the beds
	 */
	public List<BedCostDTO> getBeds() {
		return beds;
	}

	/**
	 * @param beds the beds to set
	 */
	public void setBeds(List<BedCostDTO> beds) {
		this.beds = beds;
	}


}
