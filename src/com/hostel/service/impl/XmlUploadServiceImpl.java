package com.hostel.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



import com.hostel.model.BedDTO;
import com.hostel.model.HostelDTO;
import com.hostel.model.RoomDTO;
import com.hostel.service.XmlUploadService;


public class XmlUploadServiceImpl implements XmlUploadService {
	
	private ReadXMLFile readXMLFile;
	
	@Override
	public String uploadXmlByPath(String fileNameWithPath) {
		
		String resultStr = null;
		fileNameWithPath = new String("C:\\Users\\rajesh_duvvi\\Desktop\\Geetha\\Project\\hostel-inventory-1-20131117.XML");
		fileNameWithPath.replace("\\","/");
			
				
		readXMLFile  = new ReadXMLFile();
		readXMLFile.uploadXML(fileNameWithPath);
		/*
		System.out.println("Hostel details ");
		System.out.println("Hostel name:"+hostelDTO.getHostelName());
		System.out.println("Hostel addd  street:"+hostelDTO.getAdrStreet());
		System.out.println("Hostel check in"+hostelDTO.getCheckInTime());
		System.out.println("Rooms :: ");
		for(RoomDTO room : hostelDTO.getRooms()){
			System.out.println("Room name::"+room.getRoomName());
			for(BedDTO bed: room.getBeds()){
				System.out.println("Bed name::"+room.getRoomName());
			}
		}	*/
		return resultStr;
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
	
	

}
