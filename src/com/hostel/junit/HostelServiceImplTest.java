package com.hostel.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import junit.framework.TestCase;

import com.hostel.dao.HostelDAO;
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
	HostelDAO daomock;
	HostelDTO hostelDTO = new HostelDTO();
	RoomService roomService;

	public void setUp() throws Exception {
		System.out.println("MOCKITO CALLED");

		List<HostelDTO> myList = new ArrayList<HostelDTO>();

		hostelDTO.setHostelId(4);
		hostelServiceImpl = new HostelServiceImpl();

		daomock = Mockito.mock(HostelDAO.class);
		hostelServiceImpl.setHostelDAO(daomock);
		System.out.println(daomock);

		Mockito.when(daomock.insertHostel(hostelDTO)).thenReturn(
				hostelDTO.getHostelId());
		myList.add(hostelDTO);

		Mockito.when(daomock.getAllHostels()).thenReturn(myList);
		roomService = Mockito.mock(RoomService.class);
		System.out.println(roomService);
		hostelServiceImpl.setRoomService(roomService);
		Mockito.when(
				roomService.insertUpdateRoom(new RoomDTO(),
						hostelDTO.getHostelId())).thenReturn(4);
	}

	@Test
	public void testInsertHostel() throws Exception {

		System.out.println("testInsert CALLED");
		int result = hostelServiceImpl.insertHostel(hostelDTO);
		System.out.println(result);
		assertEquals(4, result);

	}

	@Test
	public void testgetHostels() throws Exception {
		System.out.println("get Hostel");
		List<HostelDTO> result = hostelServiceImpl.getHostels();
		assertEquals(4, result.get(0).getHostelId());

	}

}