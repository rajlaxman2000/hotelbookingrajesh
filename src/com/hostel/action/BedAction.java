package com.hostel.action;

import com.hostel.model.BedDTO;
import com.hostel.service.BedService;
import com.opensymphony.xwork2.ActionSupport;

public class BedAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	private int bedId;
	
	private String bedName;
	
	private BedDTO bedDTO;
	
	private BedService bedService;
	
	public String execute(){
		
		return null;
	}

	
	/**
	 * @return the bedService
	 */
	public BedService getBedService() {
		return bedService;
	}


	/**
	 * @param bedService the bedService to set
	 */
	public void setBedService(BedService bedService) {
		this.bedService = bedService;
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
	 * @return the bedDTO
	 */
	public BedDTO getBedDTO() {
		return bedDTO;
	}

	/**
	 * @param bedDTO the bedDTO to set
	 */
	public void setBedDTO(BedDTO bedDTO) {
		this.bedDTO = bedDTO;
	}
	
	

	
}
