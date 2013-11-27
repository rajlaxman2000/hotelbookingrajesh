package com.hostel.commandline;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hostel.model.BedCostDTO;
import com.hostel.model.CustomerDTO;
import com.hostel.model.OrderBedDTO;
import com.hostel.model.OrderDTO;
import com.hostel.model.RevenueDTO;
import com.hostel.service.CustomerService;
import com.hostel.service.HostelService;
import com.hostel.service.OrderService;
import com.hostel.service.SearchService;
import com.hostel.service.XmlUploadService;
import com.hostel.util.AppUtil;


public class CommandProcessor {
	
	public XmlUploadService xmlUploadService;
	
	public HostelService hostelService;
	
	public SearchService searchService;
	
	public CustomerService customerService;
	
	public OrderService orderService;
	
	public SearchResultDTO searchResultDTO;
	
	public CommandDTO commandDTO;
	
	
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
			adminRevenue(commandDTO);	
		}
		else if(cmdStr.equalsIgnoreCase("admin_occupancy")){
			adminOccupancy(commandDTO);
		}
		else if(cmdStr.equalsIgnoreCase("book_add")){
			bookAddMethod(commandDTO);
		}
		else if(cmdStr.equalsIgnoreCase("book_cancel")){
			bookCancelMethod(commandDTO);
		}
		else if(cmdStr.equalsIgnoreCase("book_view")){
			bookViewMethod(commandDTO);
		}
		else if(cmdStr.equalsIgnoreCase("user_add")){
			userAddMethod(commandDTO);
		}
		else if(cmdStr.equalsIgnoreCase("user_edit")){
			userEditMethod(commandDTO);
		}
		else if(cmdStr.equalsIgnoreCase("user_view")){
			userSearchMethid(commandDTO);
		}else{
			System.out.println("We are not supporting other operations at thi spoint of time.");
		}

		/*for (Map.Entry<String, String> entry : commandDTO.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}*/
		System.out.println();
	}
	
	public void adminRevenue(CommandDTO commandDTO){
		
		String startDateStr = commandDTO.getCmdParams().get("start_date");
		String endDateStr = commandDTO.getCmdParams().get("end_date");
		Date startDate=null,endDate=null;
		if(startDateStr!=null && endDateStr!=null && AppUtil.checkValidDateStr(startDateStr) &&  AppUtil.checkValidDateStr(endDateStr) ){
			startDate = AppUtil.getSqlDateByString(startDateStr);
			endDate   = AppUtil.getSqlDateByString(endDateStr);
		}	
		try {
			RevenueDTO revenueDTO = orderService.getRevenueByDates(startDate, endDate);
			if(revenueDTO!=null){
					System.out.println("************Revenue report*********");
					System.out.println("Total revenue from Booking orders ::"+revenueDTO.getTotalOrdersRevenue());
					System.out.println("Total revenue lost from cancellation returns ::"+revenueDTO.getTotalCancelAmount());
					System.out.println("Actual complete revenue:: "+revenueDTO.getTotalGeneratedRevenue());
			}else{
				System.out.println("No report avaibale for the given critera, please try with some other criteria");
			}
		} catch (Exception e) {
			System.err.println("There was some problem in fetching the revenue, pleas etry again later");
		}
			
		System.out.println("I am in admin revenue section and good to go for servie class");	
	}
	
	
	public void adminOccupancy(CommandDTO commandDTO){
		System.out.println("I am in admin revenue section and good to go for servie class");	
	}
	public void bookCancelMethod(CommandDTO commandDTO){
		//order_id can_before_hrs
		int orderId, canHrs=0;		
		if(commandDTO.getCmdParams().get("order_id") !=null && commandDTO.getCmdParams().get("order_id").matches(AppUtil.numbRegEx)){
			orderId =Integer.valueOf(commandDTO.getCmdParams().get("order_id")).intValue();
			if(commandDTO.getCmdParams().get("can_before_hrs")!=null && commandDTO.getCmdParams().get("can_before_hrs").matches(AppUtil.numbRegEx) ){
				canHrs = Integer.valueOf(commandDTO.getCmdParams().get("can_before_hrs"));				
			}
			try{
				OrderDTO orderDTO =  orderService.getOrderDetailsByOrderId(orderId);
				if(orderDTO!=null){
					OrderDTO  canceldOrder = orderService.cancelOrder(orderDTO,canHrs);
					if(canceldOrder!=null){
						System.out.println("***************************************************************");
						System.out.println("Order has been cancelled successfully");
						System.out.println("cancelled Order details ::");
						System.out.println("***************************************************************");
						System.out.println("----------------------------------------------------------------");
						System.out.println("Order Id : "+canceldOrder.getOrderId()+", Returned Amount After cancellation : "+ canceldOrder.getOrderCancelAmt());
					}else{
						System.out.println("There was some problem to cancel the given order, please try after some time.");
					}
				}else{
					System.out.println("There is no order for th egiven order id"); 
				}
			}catch (Exception e) {
			System.err.println("There was some problem to cancel the given order, please try after some time.");
			}
		}else{
			System.out.println("At least correct order id is required to cancel the order");
		}
	}
	
	public void bookViewMethod(CommandDTO commandDTO){
		String emailId =null;
		
		Date startDate=null,endDate=null;		
		if(commandDTO.getCmdParams().get("user_emailId") !=null){
			emailId =commandDTO.getCmdParams().get("user_emailId");
		}	
		if(commandDTO.getCmdParams().get("start_date")!=null && commandDTO.getCmdParams().get("end_date")!=null){
			startDate = AppUtil.getSqlDateByString(commandDTO.getCmdParams().get("start_date"));
			endDate = AppUtil.getSqlDateByString(commandDTO.getCmdParams().get("end_date"));
		}
		try {
			List<OrderDTO> orders  = orderService.getOrdersByDateRangeCustEmail(startDate, endDate, emailId);
			if(orders!=null && orders.size()>0){
				System.out.println("***************************************************************");
				System.out.println("Order details ::");
				System.out.println("***************************************************************");
				for(OrderDTO order : orders){
					System.out.println("----------------------------------------------------------------");
					System.out.println("Order Id : "+order.getOrderId()+", Order amount : "+order.getOrderCost()+"Customer Email id ::"+order.getEmailId()+" Order palced Date"+order.getOrderPlcdDate());
					System.out.println(" Order started Date : "+order.getOrderStartDate()+" Order End date : "+order.getOrderEndDate());
				}
			}else{
				System.out.println("There is no oders fo rthe given serach criteria, please try with new criteria");
			}	
		} catch (Exception e) {
			System.out.println("There was some problem to fetch the orders with given details, Please try again later");
		}
		
	}
	public void bookAddMethod(CommandDTO commandDTO){
		//("bed_ids","user_id","start_date","end_date")
		String bedIds[] = commandDTO.getCmdParams().get("bed_ids").split(",");
		String userIdStr = commandDTO.getCmdParams().get("user_id");
		String startDatStr = null,endDateStr=null;
		if(commandDTO.getCmdParams().get("start_date")!=null && commandDTO.getCmdParams().get("end_date")!=null){
			startDatStr = commandDTO.getCmdParams().get("start_date");
			endDateStr = commandDTO.getCmdParams().get("end_date");
		}	
		Date startDate,endDate;
		
		boolean result= false;
		OrderDTO orderDTO = new OrderDTO();
		List<OrderBedDTO> orderBedDtos = new ArrayList<OrderBedDTO>(); 
		if(startDatStr!=null && endDateStr!=null && AppUtil.checkValidDateStr(startDatStr) 
				&& AppUtil.checkValidDateStr(endDateStr) && userIdStr.matches(AppUtil.numbRegEx)){
			startDate = AppUtil.getSqlDateByString(startDatStr);
			endDate = AppUtil.getSqlDateByString(endDateStr);
			if(this.searchResultDTO.getStartDate()!=null && this.searchResultDTO.getEndDate()!=null && 
					this.searchResultDTO.getStartDate().compareTo(startDate)<0 && this.searchResultDTO.getEndDate().compareTo(endDate)>0)
				result = true;
			for (String bedIdStr : bedIds){
				bedIdStr.trim();
				if(bedIdStr.matches(AppUtil.numbRegEx) && this.searchResultDTO.getBedIs().contains(Integer.valueOf(bedIdStr))){
					
					result = true;
					int bedId = Integer.valueOf(bedIdStr).intValue();
					orderBedDtos.add(new OrderBedDTO(bedId));					
				}	
			}
			
			if(result){
				orderDTO.setCustomerId(Integer.valueOf(userIdStr).intValue());
				orderDTO.setHostelId(this.searchResultDTO.getHostelId());
				orderDTO.setOrderBeds(orderBedDtos);
				orderDTO.setOrderStartDate(startDate);
				orderDTO.setOrderEndDate(endDate);
				orderDTO.setOrderCancelAmt(0);
				float cost = calculateOrderCost(this.searchResultDTO.getResultBedCosts(),startDate, endDate, bedIds);
				orderDTO.setOrderCost(cost);
				System.out.println("Calculated cost :: "+cost);
				System.out.println("I am goog to go to service layer");
				try {
					int orderId = orderService.createOrder(orderDTO);
					//write some thing to get it printed  
				} catch (Exception e) {
					System.out.println("There is an problem to book order, please try again");
					e.printStackTrace();
				}
				//order_cost order_cancel_amt  order_cancel_date order_placed_date (CURDATE()) order_start_date order_end_date active
				
			
			}else{
				System.err.println("Order book detaisl doesn't match with last search criteria, please try once again");
			}
		}else{
			System.out.println("Please enter valid params with proper data types to proceed order");
			commandDTO.setPrvCmdName("search");
		}
		
	}
	public float calculateOrderCost(List<BedCostDTO> bedCostDTOs, Date startDate,Date endDate,String[] beds){
		
		
		/* if gievn start date 
		 * dto.daterange1<startDate<dta.daterange2 or dto.daterange1<endDate>dto.daterange2
		 * */
		float cost=0;int id=0;
		for(String bed : beds){			
			id = Integer.valueOf(bed).intValue();
			for(BedCostDTO dto : bedCostDTOs){
				if(	id == dto.getBedId() && 
						((dto.getDateRange1().compareTo(startDate)<=0 && startDate.compareTo(dto.getDateRange2())<=0) 
								|| (dto.getDateRange1().compareTo(endDate)<=0 &&  endDate.compareTo(dto.getDateRange2())<=0)) ){
					cost = cost + dto.getBedCost();
				}	
			}			
		}
				
		return cost;
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
			cityName.replaceAll("_", " ");
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
		this.searchResultDTO = new SearchResultDTO();  
		this.commandDTO = commandDTO;
		try {			
			availableBeds = searchService.searchByCriteria(cityName, startDate, endDate, noOFBeds);
			if(availableBeds!=null && availableBeds.size()>0){
				System.out.println( "-----------------------------------------------------------------------------------------------------------------");
				Collections.sort(availableBeds);				
				for(BedCostDTO bedCostDto: availableBeds ){
					System.out.println("Bed serach id:: "+bedCostDto.getBedId() +"-- StartDate:"+bedCostDto.getDateRange1()+" to -- EndDate:"+bedCostDto.getDateRange2()+" :: cost ::"+bedCostDto.getBedCost()+"$");
					System.out.println( "-----------------------------------------------------------------------------------------------------------------");					
				}
				 
				searchResultDTO.setResultBedCosts(availableBeds);
				searchResultDTO.setStartDate(startDate);
				searchResultDTO.setEndDate(endDate);
				searchResultDTO.setNoOfBeds(noOFBeds);
				setSearchResultDTO(searchResultDTO);
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


	/**
	 * @return the orderService
	 */
	public OrderService getOrderService() {
		return orderService;
	}


	/**
	 * @param orderService the orderService to set
	 */
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}


	/**
	 * @return the searchResultDTO
	 */
	public SearchResultDTO getSearchResultDTO() {
		return searchResultDTO;
	}


	/**
	 * @param searchResultDTO the searchResultDTO to set
	 */
	public void setSearchResultDTO(SearchResultDTO searchResultDTO) {
		this.searchResultDTO = searchResultDTO;
	}	
	
	

}
