package com.hostel.service.impl;
import java.io.File;

import com.hostel.model.BedCostDTO;
import com.hostel.model.BedDTO;
import com.hostel.model.HostelDTO;
import com.hostel.model.RoomDTO;
import com.hostel.service.HostelService;
import com.hostel.service.XmlUploadService;


public class XmlUploadServiceImpl implements XmlUploadService {
	
	private ReadXMLFile readXMLFile;
	
	private HostelService hostelService;
	
	
	
	@Override
	public String uploadXmlByPath(String fileNameWithPath) {
		
		String resultStr = null;	
		File f = new File(fileNameWithPath);
		if(f.exists() && (fileNameWithPath.contains(".XML") || fileNameWithPath.contains(".xml"))){
			fileNameWithPath.replace("\\","/");
			HostelDTO hostelDTO= ReadXMLFile.uploadXML(fileNameWithPath);
			
			if(hostelDTO!=null){
				try {
					int hostelId = hostelService.insertHostel(hostelDTO);
					hostelDTO.setHostelId(hostelId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Hostel details ");
			System.out.println("Hostel name:"+hostelDTO.getHostelName());
			System.out.println("Hostel addd  street:"+hostelDTO.getAdrStreet());
			System.out.println("Hostel check in"+hostelDTO.getCheckInTime());
			System.out.println("Rooms :: ");
			for(RoomDTO room : hostelDTO.getRooms()){
				System.out.println("Room name::"+room.getRoomName());
				for(BedDTO bed: room.getBeds()){
					System.out.println("	Bed name::"+bed.getBedName());
					for(BedCostDTO costDTO : bed.getCostDTOs()){
						System.out.println("	Bed Date ::"+costDTO.getDateRange1());
						System.out.println("	Bed Cost ::"+costDTO.getBedCost());
					}
				}
			}
		}else{
			System.out.println("File path can't be empty  or please provide XML file path only or make sure file has proper file extension");
		}
		return "This message is not going to be used";
	}

	/**
	 * @return the readXMLFile
	 */
	public ReadXMLFile getReadXMLFile() {
		return readXMLFile;
	}

	/**
	 * @param readXMLFile the readXMLFile to set
	 */
	public void setReadXMLFile(ReadXMLFile readXMLFile) {
		this.readXMLFile = readXMLFile;
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
