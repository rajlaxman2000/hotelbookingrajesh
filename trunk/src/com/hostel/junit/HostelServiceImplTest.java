package com.hostel.junit;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import junit.framework.TestCase;

import com.hostel.dao.HostelDAO;
import com.hostel.model.BedDTO;
import com.hostel.model.HostelDTO;
import com.hostel.model.RoomDTO;
import com.hostel.service.RoomService;
import com.hostel.service.impl.HostelServiceImpl;

public class HostelServiceImplTest extends TestCase {

	/*
	 * @Before protected void setUp() throws Exception {
	 * MockitoAnnotations.initMocks(this); }
	 */
	HostelServiceImpl hostelServiceImpl;
	HostelDAO hostelDaoMock;
	HostelDTO hostelDTO = new HostelDTO();
	RoomService roomService;

	public void setUp() throws Exception {
		List<HostelDTO> myList = new ArrayList<HostelDTO>();

		hostelDTO.setHostelId(4);
		myList.add(hostelDTO);
		hostelServiceImpl = new HostelServiceImpl();

		hostelDaoMock = Mockito.mock(HostelDAO.class);
		roomService = Mockito.mock(RoomService.class);

		hostelServiceImpl.setHostelDAO(hostelDaoMock);
		hostelServiceImpl.setRoomService(roomService);

		Mockito.when(hostelDaoMock.insertHostel(hostelDTO)).thenReturn(
				hostelDTO.getHostelId());

		Mockito.when(hostelDaoMock.getAllHostels()).thenReturn(myList);

		Mockito.when(hostelDaoMock.getAllHostelsByCity("my_city")).thenReturn(
				myList);

		Mockito.when(
				roomService.insertUpdateRoom(new RoomDTO(),
						hostelDTO.getHostelId())).thenReturn(4);
	}

	public void testInsertHostel() throws Exception {
		RoomDTO roomDTO = new RoomDTO();
		List<BedDTO> bedDTOs = new ArrayList<BedDTO>();
		List<RoomDTO> roomDTOs = new ArrayList<RoomDTO>(2);
		roomDTO.setBeds(bedDTOs);
		roomDTOs.add(roomDTO);
		hostelDTO.setRooms(roomDTOs);
		int result = hostelServiceImpl.insertHostel(hostelDTO);
		assertEquals(4, result);

	}

	public void testGetHostels() throws Exception {

		List<HostelDTO> result = hostelServiceImpl.getHostels();
		assertEquals(4, result.get(0).getHostelId());

	}

	public void testSearchHostelsByCity() throws Exception {
		List<HostelDTO> hostelDTOListResult = hostelServiceImpl
				.searchHostelsByCity("my_city");
		assertEquals(4, hostelDTOListResult.get(0).getHostelId());
	}
}