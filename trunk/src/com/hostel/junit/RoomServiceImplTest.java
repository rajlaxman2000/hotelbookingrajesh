package com.hostel.junit;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import org.mockito.Mockito;

import com.hostel.dao.BedDAO;
import com.hostel.dao.RoomDAO;
import com.hostel.model.BedDTO;
import com.hostel.model.RoomDTO;
import com.hostel.service.BedService;
import com.hostel.service.impl.RoomServiceImpl;

public class RoomServiceImplTest extends TestCase {

	RoomServiceImpl roomServiceImpl;
	RoomDAO roomDAOmock;
	BedDAO bedDAOmock;
	BedService bedServiceMock;
	RoomDTO roomDTO = new RoomDTO();
	List<BedDTO> bedDTOs = new ArrayList<BedDTO>();
	List<RoomDTO> roomDTOs = new ArrayList<RoomDTO>();

	public void setUp() throws Exception {
		roomDTO.setRoomName("myroom");
		roomDTOs.add(roomDTO);

		// creating mock instances for DAOs
		roomServiceImpl = new RoomServiceImpl();
		roomDAOmock = Mockito.mock(RoomDAO.class);
		bedDAOmock = Mockito.mock(BedDAO.class);
		bedServiceMock = Mockito.mock(BedService.class);
		roomDTO = Mockito.mock(RoomDTO.class);

		roomServiceImpl.setBedDAO(bedDAOmock);
		roomServiceImpl.setBedService(bedServiceMock);
		roomServiceImpl.setRoomDAO(roomDAOmock);

		Mockito.when(roomDAOmock.InsertRoom(roomDTO, 1)).thenReturn(1);
		Mockito.when(bedServiceMock.insertUpdateBed(null, 1)).thenReturn(1);

		Mockito.when(roomDTO.getBeds()).thenReturn(bedDTOs);
		Mockito.when(roomDAOmock.getRoomsbyHostelId(1)).thenReturn(roomDTOs);
		Mockito.when(bedDAOmock.getBedsByRoomId(1)).thenReturn(bedDTOs);
	}

	public void testInsertUpdateRoom() throws Exception {

		int result = roomServiceImpl.insertUpdateRoom(roomDTO, 1);

		assertEquals(1, result);
	}

	public void testGetRooms() throws Exception {

		List<RoomDTO> roomDTOsResult = roomServiceImpl.getRooms(1);

		assertEquals("myroom", roomDTOsResult.get(0).getRoomName());
	}

}
