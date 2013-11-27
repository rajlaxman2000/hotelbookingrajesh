package com.hostel.junit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hostel.commandline.AvailableDTO;
import com.hostel.model.HostelDTO;
import com.hostel.model.RoomDTO;
import com.hostel.service.impl.ReadXMLFile;

import junit.framework.TestCase;

public class ReadXMLFileTest extends TestCase {

	Map<String, String> params;
	List<AvailableDTO> availDTOs;
	HostelDTO hostelDTO;

	public void setUp() throws Exception {

		params = new HashMap<String, String>();
		params.put("name", "my_hostel");
		params.put("cancellation_deadline", "15");
		params.put("cancellation_penalty", "50");

		AvailableDTO availableDTO = new AvailableDTO();
		availableDTO.setRoomName("my_room");

		availDTOs = new ArrayList<AvailableDTO>();
		availDTOs.add(availableDTO);

	}

	public void testUpdateClassVars() {
		ReadXMLFile.updateClassVars(params, availDTOs);
		assertEquals("my_room", ReadXMLFile.mainAvailableDTOs.get(0).getRoomName());
		assertEquals("my_hostel", ReadXMLFile.mainParams.get("name"));
	}

	public void testUploadXML() {
		HostelDTO hostelDTOResult = ReadXMLFile.uploadXML("my_path"); // invalid path--->hence raises exception
		assertEquals("my_hostel", hostelDTOResult.getHostelName());
	}

	public void testBuildHostelDTO() {

		hostelDTO = ReadXMLFile.buildHostelDTO(params, availDTOs);
		assertEquals("my_hostel", hostelDTO.getHostelName());
	}

	public void testBuildRooms() {

		List<RoomDTO> roomDTOsResult = ReadXMLFile.buildRooms(availDTOs);
		assertEquals("my_room", roomDTOsResult.get(0).getRoomName());

	}
}
