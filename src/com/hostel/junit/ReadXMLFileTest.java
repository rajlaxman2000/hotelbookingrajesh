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
		System.out.println("setup");
		params = new HashMap<String, String>();
		params.put("name", "my_hostel");
		params.put("cancellation_deadline", "15");
		params.put("cancellation_penalty", "50");
		availDTOs = new ArrayList<AvailableDTO>();
		AvailableDTO availableDTO = new AvailableDTO();
		availableDTO.setRoomName("my_room");
		availDTOs.add(availableDTO);

	}

	public void testBuildHostelDTO() {
		System.out.println("method 1");
		hostelDTO = ReadXMLFile.buildHostelDTO(params, availDTOs);
		assertEquals("my_hostel", hostelDTO.getHostelName());
	}

	public void testBuildRooms() {
		System.out.println("method 1");
		List<RoomDTO> roomDTOsResult = ReadXMLFile.buildRooms(availDTOs);
		assertEquals("my_room", roomDTOsResult.get(0).getRoomName());

	}
}
