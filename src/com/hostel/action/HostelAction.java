package com.hostel.action;

import java.util.List;

import com.hostel.model.HostelDTO;
import com.hostel.service.HostelService;
import com.opensymphony.xwork2.ActionSupport;

public class HostelAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	/* Hostel DTO Details : Begin*/ 
	private int hostelId;
	
	private String hostelName;
	
	private String hostelAddr1;
	
	private String hostelAddr2;
	
	private String hostelCity;
	
	private String hostelCountry;
	
	private List<HostelDTO> hostels;
	
	/* Hostel DTO Details : End*/
	
	private HostelService hostelService;
	


	public String execute() {
		
		try {
			hostels = hostelService.getHostels();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
		 
	 }
	
	
	
	/**
	 * @return the hostelService
	 */
	public HostelService getHostelService() {
		return hostelService;
	}



	/**
	 * @param hostelService the hostelService to set
	 */
	public void setHostelService(HostelService hostelService) {
		this.hostelService = hostelService;
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
	 * @return the hostelAddr1
	 */
	public String getHostelAddr1() {
		return hostelAddr1;
	}



	/**
	 * @param hostelAddr1 the hostelAddr1 to set
	 */
	public void setHostelAddr1(String hostelAddr1) {
		this.hostelAddr1 = hostelAddr1;
	}



	/**
	 * @return the hostelAddr2
	 */
	public String getHostelAddr2() {
		return hostelAddr2;
	}



	/**
	 * @param hostelAddr2 the hostelAddr2 to set
	 */
	public void setHostelAddr2(String hostelAddr2) {
		this.hostelAddr2 = hostelAddr2;
	}



	/**
	 * @return the hostelCity
	 */
	public String getHostelCity() {
		return hostelCity;
	}



	/**
	 * @param hostelCity the hostelCity to set
	 */
	public void setHostelCity(String hostelCity) {
		this.hostelCity = hostelCity;
	}



	/**
	 * @return the hostelCountry
	 */
	public String getHostelCountry() {
		return hostelCountry;
	}



	/**
	 * @param hostelCountry the hostelCountry to set
	 */
	public void setHostelCountry(String hostelCountry) {
		this.hostelCountry = hostelCountry;
	}



	/**
	 * @return the hostels
	 */
	public List<HostelDTO> getHostels() {
		return hostels;
	}



	/**
	 * @param hostels the hostels to set
	 */
	public void setHostels(List<HostelDTO> hostels) {
		this.hostels = hostels;
	}


	
	

}
