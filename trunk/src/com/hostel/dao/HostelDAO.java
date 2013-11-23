package com.hostel.dao;

import java.util.List;

import com.hostel.model.HostelDTO;

public interface HostelDAO {
	
	public List<HostelDTO> getAllHostels() throws Exception;
	
	public HostelDTO getHostelDetailsById(int hostelId) throws Exception;
	
	public final String getHostelsQuery="select hostel_id, hostel_name from hostel";
	
	public final String getHostelDetailsByIdQuery="select h.hostel_id, h.hostel_name, a.address_line_no1, a.address_line_no2, a.city, a.country from hostel h " +
			"inner join address a on a.address_id=h.hostel_address_id"+
			"where h.hostel_id=:hostelId";
		
}
