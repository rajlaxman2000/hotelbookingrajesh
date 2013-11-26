package com.hostel.junit;

import java.util.ArrayList;
import java.util.List;
import org.mockito.Mockito;

import com.hostel.dao.BedCostDAO;
import com.hostel.dao.BedDAO;
import com.hostel.model.BedCostDTO;
import com.hostel.model.BedDTO;
import com.hostel.service.impl.BedServiceImpl;

import junit.framework.TestCase;

public class BedServiceImplTest extends TestCase {

	BedServiceImpl bedServiceImpl;
	BedDAO bedDAO;
	BedCostDAO bedCostDAO;

	java.sql.Date date1 = new java.sql.Date(12);
	java.sql.Date date2 = new java.sql.Date(13);
	BedCostDTO bedCostDTO = new BedCostDTO();
	BedDTO bedDTO = new BedDTO();

	List<BedCostDTO> bedCostList = new ArrayList<BedCostDTO>();
	List<BedDTO> bedList = new ArrayList<BedDTO>();

	public void setUp() throws Exception {

		bedCostDTO.setBedId(5);
		bedCostDTO.setDateRange1(date1);
		bedCostDTO.setDateRange2(date2);

		bedCostList.add(bedCostDTO);

		bedServiceImpl = new BedServiceImpl();
		bedCostDAO = Mockito.mock(BedCostDAO.class);
		bedDAO = Mockito.mock(BedDAO.class);
		bedDTO = Mockito.mock(BedDTO.class);

		bedServiceImpl.setBedCostDAO(bedCostDAO);
		bedServiceImpl.setBedDAO(bedDAO);

		Mockito.when(
				bedCostDAO.getBedCostDTOsByDatesForSearch(
						bedCostDTO.getBedId(), bedCostDTO.getDateRange1(),
						bedCostDTO.getDateRange2())).thenReturn(bedCostList);
		Mockito.when(
				bedCostDAO.getBedCostDTOsByForSearch(bedCostDTO.getBedId()))
				.thenReturn(bedCostList);

		Mockito.when(bedDAO.insertBed(bedDTO, 1)).thenReturn(5);

		Mockito.when(bedDTO.getCostDTOs()).thenReturn(bedCostList);

	}

	public void testGetBedCostsByHostelIdDateRanges() throws Exception {
		List<BedCostDTO> result = bedServiceImpl
				.getBedCostsByHostelIdDateRanges(bedCostDTO.getBedId(),
						bedCostDTO.getDateRange1(), bedCostDTO.getDateRange2());
		assertEquals(5, result.get(0).getBedId());

	}

	public void testInsertUpdateBed() throws Exception {

		int result = bedServiceImpl.insertUpdateBed(bedDTO, 1);

		assertEquals(5, result);
	}

}
