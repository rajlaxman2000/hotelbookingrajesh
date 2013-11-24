package com.hostel.commandline;

import java.util.Map;

import com.hostel.service.HostelService;
import com.hostel.service.XmlUploadService;


public class CommandProcessor {
	
	public XmlUploadService xmlUploadService;
	
	public HostelService hostelService;
	
	public void adminLoadMethod(CommandDTO commandDTO){
		
		//fileNameWithPath = new String("C:\\Users\\rajesh_duvvi\\Desktop\\Geetha\\Project\\hostel-inventory-1-20131117.XML");
		String s = xmlUploadService.uploadXmlByPath(commandDTO.getCmdParams().get("path"));		
	}
	
	/*
	 * search, book_add, book_cancel, book_view, user_add, user_change, user_view, admin_load, admin_revenue, admin_occupancy
	 */
	
	public void startProcessing(CommandDTO commandDTO){
		
		String cmdStr;
		StringBuilder cmdStrBuilder = new StringBuilder();
			cmdStrBuilder.append(commandDTO.getCmdName());
		if(commandDTO.getSubCmdName()!=null){
			cmdStrBuilder.append("_").append(commandDTO.getSubCmdName());
		}
		cmdStr =  cmdStrBuilder.toString();
		
		System.out.println("Given command"+commandDTO.getCmdName()+" "+commandDTO.getSubCmdName()+" will be processed with below valid params");

		for (Map.Entry<String, String> entry : commandDTO.getCmdParams().entrySet()) {
			System.out.println("param = " + entry.getKey() + ", Value = " + entry.getValue());
		}
		
		if(cmdStr.equalsIgnoreCase("search")){
			
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
			
		}
		else if(cmdStr.equalsIgnoreCase("user_change")){
	
		}
		else if(cmdStr.equalsIgnoreCase("user_view")){
		
		}

		/*for (Map.Entry<String, String> entry : commandDTO.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}*/
		System.out.println();
		
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
	
	
	

}
