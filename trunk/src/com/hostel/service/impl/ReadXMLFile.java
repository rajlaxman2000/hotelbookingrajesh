package com.hostel.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.hostel.commandline.AvailableDTO;
import com.hostel.model.BedCostDTO;
import com.hostel.model.BedDTO;
import com.hostel.model.HostelDTO;
import com.hostel.model.RoomDTO;
 
public class ReadXMLFile {
   
   static List<AvailableDTO> mainAvailableDTOs;	
   static Map<String, String> mainParams;	
   static HostelDTO hostelDTO;
   
   
   public ReadXMLFile(){
	   mainParams = new HashMap<String, String>();
	   mainAvailableDTOs = new ArrayList<AvailableDTO>();
   }
   
   public static void updateClassVars(Map<String, String> params, List<AvailableDTO> availDTOs){
	   mainParams = params;
	   mainAvailableDTOs = availDTOs;	   
   }
   
   public static HostelDTO uploadXML(String filePath){	  
	   processXML(filePath);
	   hostelDTO = ReadXMLFile.buildHostelDTO(mainParams,mainAvailableDTOs);
	   return hostelDTO;		
   }

   public static void processXML(String filePath) {
     
	    try {
	 
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handler = null;
			
			
		    
		    
			
			
			handler = new DefaultHandler() { 
				
				boolean canAdd = false;
				
			    String paramName;
			    ArrayList<String> nodeNames = new ArrayList<String>(Arrays.asList("name","street","city", "state","country","postal_code","phone","email","facebook","web"
			    		,"check_in_time","check_out_time","smoking","alcohol","cancellation_deadline","cancellation_penalty","date","room","bed", "price"));
			    ArrayList<String> availbleNodeNames = new ArrayList<String>(Arrays.asList("date","room","bed", "price"));
				AvailableDTO availableDTO;
				Map<String, String> params = new HashMap<String, String>();
				List<AvailableDTO> availableDTOs = new ArrayList<AvailableDTO>();
			    
			  	public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
			 		
					if(qName.equalsIgnoreCase("availability")){
						createAvailDTO();
					}
					if(nodeNames.contains(qName)){
						paramName = qName;
						canAdd = true;
					}
				}
			 
				public void endElement(String uri, String localName, String qName) throws SAXException {
					if(qName.equalsIgnoreCase("availability")){
						addAvailDTO();
					}
					
				}
			 
				public void characters(char ch[], int start, int length) throws SAXException {					
					if(canAdd){
						addToMap(new String(ch, start, length));
					}
				}
				
				public void endDocument (){					
					ReadXMLFile.updateClassVars(params, availableDTOs);
				}	

				public void createAvailDTO(){
					availableDTO  = new AvailableDTO();
				}
				
				public void addAvailDTO(){
					availableDTOs.add(availableDTO);
				}
				
				public void addToMap(String val){
					val = val.trim().replaceAll("[\\t\\n\\r]"," ");					
					if(!val.isEmpty() ){
						if(availbleNodeNames.contains(paramName)){
							if(paramName.equalsIgnoreCase("date")){
								StringBuilder dateStringBuilder = new StringBuilder();
								//(yyyy-mm-dd)
								//20140701
								dateStringBuilder.append(val.substring(0,4)).append("-").append(val.substring(6)).append("-").append(val.substring(4,6));								
								availableDTO.setDateStr(val);
								availableDTO.setDate(Date.valueOf(dateStringBuilder.toString()));
								
								
							}else if(paramName.equalsIgnoreCase("room")){	
								availableDTO.setRoomName("room-"+val);
							}else if(paramName.equalsIgnoreCase("bed")){	
								availableDTO.setBedName("bed-"+val);
							}else if(paramName.equalsIgnoreCase("price")){
								int p = Integer.valueOf(val).intValue();								
								availableDTO.setPrice((float)p);
							}
						}else{
							params.put(paramName, val);
						}
					}	
				}
				  
							
		     };
		     saxParser.parse(filePath, handler); 
	     }catch (Exception e) {
	       e.printStackTrace();
	       System.out.println("I am coming here");
	     }
     
   }
    
    public static HostelDTO buildHostelDTO(Map<String, String> paramMaps, List<AvailableDTO> dtos){    	
    	
    	HostelDTO hostelDTO= new HostelDTO();
    	hostelDTO.setHostelId(0);
    	hostelDTO.setHostelName(paramMaps.get("name"));
    	hostelDTO.setPhone(paramMaps.get("phone"));
    	hostelDTO.setEmail(paramMaps.get("email"));
    	hostelDTO.setFacebook(paramMaps.get("facebook"));
    	hostelDTO.setWeb(paramMaps.get("web"));
    	hostelDTO.setCheckInTime(paramMaps.get("check_in_time"));
    	hostelDTO.setCheckOutTime(paramMaps.get("check_out_time"));
    	hostelDTO.setAlcohol(paramMaps.get("alcohol"));
    	hostelDTO.setSmoking(paramMaps.get("smoking"));;
    	hostelDTO.setOrderCancellationHoursLimit(Integer.valueOf(paramMaps.get("cancellation_deadline")));
    		String percant = paramMaps.get("cancellation_penalty");
    		   		
    	hostelDTO.setCancellationFeePercant(Integer.valueOf(percant.replaceAll("%"," ").trim()));
    	hostelDTO.setAdrStreet(paramMaps.get("street"));
    	hostelDTO.setAdrCity(paramMaps.get("city"));
    	hostelDTO.setAdrState(paramMaps.get("state"));
    	hostelDTO.setAdrPostalCode(paramMaps.get("postal_code"));
    	hostelDTO.setAdrCountry(paramMaps.get("country"));	
    		
    	hostelDTO.setRooms(buildRooms(dtos));   	
    	
    	return hostelDTO;
    }
    
    
    public static List<RoomDTO> buildRooms(List<AvailableDTO> availDTOs){
    	
    	ArrayList<RoomDTO> rooms = new ArrayList<RoomDTO>();
    	RoomDTO room=null;
    	
    	StringBuffer roomNamesList = new StringBuffer();
    	
    	BedCostDTO bedCostDTO = null;		
		Map<String, ArrayList<BedCostDTO>> bedCostsMap = new HashMap<String, ArrayList<BedCostDTO>>(5);
		
		BedDTO bed=null;
		Map<String, ArrayList<BedDTO>> bedsMap = new HashMap<String, ArrayList<BedDTO>>();
		
		Map<String, String> testMap = new HashMap<String, String>();
		
		
    	for(AvailableDTO dto : availDTOs ){    		
    		if(rooms.size()>0 && roomNamesList.toString().contains(dto.getRoomName())){    			
    		}else{
    			room = new RoomDTO();
    			room.setRoomId(0);
    			room.setRoomName(dto.getRoomName());
    			rooms.add(room);
    			roomNamesList.append(dto.getRoomName()).append("_");
    		}
    		
    		    
    		// Begin :: adding beds to map by key
    		String bedKey = dto.getRoomName();
    		bed = new BedDTO();
    		bed.setBedId(0);
    		bed.setBedName(dto.getBedName());
    		String bedRunKey = dto.getRoomName()+"_"+dto.getBedName();
    		
    		if(bedsMap.containsKey(bedKey)){
	    		if(testMap.size()>=1 && !testMap.containsKey(bedRunKey) ){
	    			bedsMap.get(bedKey).add(bed);
	    		}
    		}else{
	    		ArrayList<BedDTO> beds = new ArrayList<BedDTO>();
    			beds.add(bed);
    			bedsMap.put(bedKey, beds);
	    	}
    		testMap.put(bedRunKey,bedRunKey);		
	    	// End :: adding beds to map by key
    		
    		
    		// Begin : Adding bed costs to a map by key ex : room-1_bed1
    		String roomBedKey = dto.getRoomName()+"_"+dto.getBedName();
			bedCostDTO = new BedCostDTO();
			bedCostDTO.setDateRange1(dto.getDate());
			bedCostDTO.setDateRange1Str(dto.getDateStr());
			bedCostDTO.setBedCost(dto.getPrice());  
			
			if(bedCostsMap.containsKey(roomBedKey)){    			
				 bedCostsMap.get(roomBedKey).add(bedCostDTO);
			}else{
				ArrayList<BedCostDTO> bedCostDTOs  = new ArrayList<BedCostDTO>();
				bedCostDTOs.add(bedCostDTO);
				bedCostsMap.put(roomBedKey, bedCostDTOs);
			}
			//End : Adding bed costs to a map
    	}
    	
    	//Doing the final association to the rooms with their respective beds and its bedCosts
    	for (RoomDTO roomDto :  rooms){
    		roomDto.setBeds(bedsMap.get(roomDto.getRoomName()));
    		for(BedDTO bedDTO : roomDto.getBeds()){
    			String keyStr = roomDto.getRoomName()+"_"+bedDTO.getBedName();
    			bedDTO.setCostDTOs(bedCostsMap.get(keyStr));
    		}
    	}
    	return rooms;
    }
    

 
}
