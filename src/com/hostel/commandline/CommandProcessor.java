package com.hostel.commandline;


import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.hostel.model.BedCostDTO;
import com.hostel.model.CustomerDTO;
import com.hostel.service.CustomerService;
import com.hostel.service.HostelService;
import com.hostel.service.SearchService;
import com.hostel.service.XmlUploadService;
import com.hostel.util.AppUtil;


public class CommandProcessor {
	
	public XmlUploadService xmlUploadService;
	
	public HostelService hostelService;
	
	public SearchService searchService;
	
	public CustomerService customerService;
	
	public void startProcessing(CommandDTO commandDTO){
		
		String cmdStr;
		String subCmdStr = "Empty";
		StringBuilder cmdStrBuilder = new StringBuilder();
			cmdStrBuilder.append(commandDTO.getCmdName());
			
		if(commandDTO.getSubCmdName()!=null){
			cmdStrBuilder.append("_").append(commandDTO.getSubCmdName());
			subCmdStr = commandDTO.getSubCmdName();
		}
		cmdStr =  cmdStrBuilder.toString();
		
		System.out.println("Given command: "+commandDTO.getCmdName()+", SubCommand : "+subCmdStr+" will be processed with below valid params");
		if(commandDTO.getCmdParams().entrySet().size() >0 || cmdStr.equalsIgnoreCase("search")){
			for (Map.Entry<String, String> entry : commandDTO.getCmdParams().entrySet()) {
				System.out.println("param = " + entry.getKey() + ", Value = " + entry.getValue());
			}
		}else{
				System.out.println("Only valid sytax params wil be considered or may be this command can be processed with out params");
		}
		
		
		if(cmdStr.equalsIgnoreCase("search")){
			searchService(commandDTO);
		}
		else if(cmdStr.equalsIgnoreCase("admin_load")){
			adminLoadMethod(commandDTO);
		}
		else if(cmdStr.equalsIgnoreCase("admin_revenue")){
				
		}
		else if(cmdStr.equalsIgnoreCase("admin_occupancy")){
			
		}
		else if(cmdStr.equalsIgnoreCase("book_add")){
			
		}
		else if(cmdStr.equalsIgnoreCase("book_cancel")){
				
		}
		else if(cmdStr.equalsIgnoreCase("book_view")){
			
		}
		else if(cmdStr.equalsIgnoreCase("user_add")){
			userAddMethod(commandDTO);
		}
		else if(cmdStr.equalsIgnoreCase("user_edit")){
			userEditMethod(commandDTO);
		}
		else if(cmdStr.equalsIgnoreCase("user_view")){
			userSearchMethid(commandDTO);
		}

		/*for (Map.Entry<String, String> entry : commandDTO.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}*/
		System.out.println();
		
	}
	
	
		
	public void adminLoadMethod(CommandDTO commandDTO){		
		
		String path = commandDTO.getCmdParams().get("path");
			if(!path.isEmpty()){
				String s = xmlUploadService.uploadXmlByPath(path);
			}else{
				System.out.println("File path can't be empty");
			}
	}
	
		
	public void searchService(CommandDTO commandDTO){
		String cityName = null,startDateStr=null,endDateStr=null;
		Date startDate=null, endDate=null;		
		int noOFBeds=0; 
		List<BedCostDTO> availableBeds =null;
		
		if(commandDTO.getCmdParams().get("city")!=null){
			cityName = commandDTO.getCmdParams().get("city");
		}
		if(commandDTO.getCmdParams().get("start_date")!=null && AppUtil.checkValidDateStr(commandDTO.getCmdParams().get("start_date"))){
			startDateStr = commandDTO.getCmdParams().get("start_date");	
			startDate = AppUtil.getSqlDateByString(startDateStr);
		}
		if(commandDTO.getCmdParams().get("end_date")!=null && AppUtil.checkValidDateStr(commandDTO.getCmdParams().get("end_date"))){
			endDateStr = commandDTO.getCmdParams().get("end_date");
			endDate = AppUtil.getSqlDateByString(endDateStr);
		}
		if(commandDTO.getCmdParams().get("beds")!=null && commandDTO.getCmdParams().get("beds").trim().matches(AppUtil.numbRegEx)){
			noOFBeds = Integer.valueOf(commandDTO.getCmdParams().get("beds")).intValue();
		}
		System.err.println("Proceeding for search with below valid criteria");
		System.out.println("city name : " +cityName+",start date : "+ startDate+ ", End Date : "+ endDate+", beds : "+noOFBeds);
		
		try {			
			availableBeds = searchService.searchByCriteria(cityName, startDate, endDate, noOFBeds);
			if(availableBeds!=null && availableBeds.size()>0){
				System.out.println( "--------------------------------------");
				for(BedCostDTO bedCostDto: availableBeds ){
					System.out.println("Bed serach id:: "+bedCostDto.getBedId() +"-- StartDate:"+bedCostDto.getDateRange1()+" to -- EndDate:"+bedCostDto.getDateRange2()+" :: cost ::"+bedCostDto.getBedCost()+"$");
					System.out.println( "--------------------------------------");
				}
			}else{
				System.out.println("There are no beds availabel for the given serach criteria, please try with new criteria");
			}	
		} catch (Exception e) {
			System.out.println("There is a problem to fetch the data by given criteria, please try again later");
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * search, book_add, book_cancel, book_view, user_add, user_change, user_view, admin_load, admin_revenue, admin_occupancy
	 * @param commandDTO
	 * @return
	 */
	
	public CustomerDTO buildCustDTO(CommandDTO commandDTO){
		CustomerDTO customerDTO =new CustomerDTO();		
		if(commandDTO.getCmdParams().get("user_id")!=null){
			customerDTO.setCustId(Integer.valueOf(commandDTO.getCmdParams().get("user_id")));
		}else{
			customerDTO.setCustId(0);			
		}
		if(commandDTO.getCmdParams().get("first_name")!=null)
			customerDTO.setFirstName(commandDTO.getCmdParams().get("first_name"));		
		if(commandDTO.getCmdParams().get("last_name")!=null)
			customerDTO.setLastName(commandDTO.getCmdParams().get("last_name"));		
		if(commandDTO.getCmdParams().get("email")!=null)
			customerDTO.setEmailId(commandDTO.getCmdParams().get("email"));		
		if(commandDTO.getCmdParams().get("cc_number")!=null)
			customerDTO.setCcNumber(commandDTO.getCmdParams().get("cc_number"));	
		if(commandDTO.getCmdParams().get("expiration_date")!=null)
			customerDTO.setExpDate(commandDTO.getCmdParams().get("expiration_date"));		
		if(commandDTO.getCmdParams().get("security_code")!=null)
			customerDTO.setSecurityCode(commandDTO.getCmdParams().get("security_code"));		
		if(commandDTO.getCmdParams().get("phone")!=null)
			customerDTO.setPhone(commandDTO.getCmdParams().get("phone"));		

		return customerDTO;
	}
	
	public void userAddMethod(CommandDTO commandDTO){
		CustomerDTO dto =null;
		try {
			dto = customerService.addCustomer(buildCustDTO(commandDTO));			
		} catch (Exception e) {
			System.out.println("There was problem to add the customer, please try again");
			e.printStackTrace();
		}
		
		System.out.println("Added customer Details");
		System.out.println("user Id : "+dto.getCustId()+"; user first name: "+dto.getFirstName()+"; user last name : "+dto.getLastName()+"; user email :"+dto.getEmailId());
	}
	
	public void userEditMethod(CommandDTO commandDTO){
			CustomerDTO dto =null;
		try {			
			dto = customerService.updateCustomer(buildCustDTO(commandDTO));
			
		} catch (Exception e) {
			System.out.println("There was problem to edit the customer, please try again");
			e.printStackTrace();
		}
		
		System.out.println("Customer Details after edit : ");
		System.out.println("user Id : "+dto.getCustId()+"; user first name: "+dto.getFirstName()+"; user last name : "+dto.getLastName()+"; user email :"+dto.getEmailId());		
	}
	
	public void userSearchMethid(CommandDTO commandDTO){		
		List<CustomerDTO> customers=null;
		CustomerDTO searchCutDTO = buildCustDTO(commandDTO); 
		if(searchCutDTO.getFirstName()!=null || searchCutDTO.getLastName()!=null || searchCutDTO.getEmailId()!=null){			
			try {
				customers = customerService.searchCustomerByCriteria(searchCutDTO.getFirstName(), searchCutDTO.getLastName(), searchCutDTO.getEmailId());
			} catch (Exception e) {
				System.out.println("There seems to be a problem for searchign with given criteria, please try again");
				e.printStackTrace();
			}
		}else{
			System.out.println("Please give the minum seatch criteria");
		}
		
		if(customers!=null && customers.size()>0){
			System.out.println("Please find the customers details nelow for the given search criteria");
			for(CustomerDTO dto:customers){
				System.out.println("user Id : "+dto.getCustId()+"; user first name: "+dto.getFirstName()+"; user last name : "+dto.getLastName()+"; user email :"+dto.getEmailId());
			}
		}else{
			System.out.println("There are no customerss avaliable for the given criteria");
		}
		
	}

	
	
	
/*
	
	public void processSearchCmd(Map<String>){
		
	}
	
	public void processBookAddCmd(){
		
	}
	
	public void processBookAddCmd(){
		
	}

	public void processBookAddCmd(){
	
	}
	
	public void processBookAddCmd(){
	
	}

	public void processUserCmd(){
		
	}*/
	
	public void processAdminCmd(){
		
	}

	


	/**
	 * @return the xmlUploadService
	 */
	public XmlUploadService getXmlUploadService() {
		return xmlUploadService;
	}

	/**
	 * @param xmlUploadService the xmlUploadService to set
	 */
	public void setXmlUploadService(XmlUploadService xmlUploadService) {
		this.xmlUploadService = xmlUploadService;
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


	/**
	 * @return the customerService
	 */
	public CustomerService getCustomerService() {
		return customerService;
	}


	/**
	 * @param customerService the customerService to set
	 */
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}	

}
