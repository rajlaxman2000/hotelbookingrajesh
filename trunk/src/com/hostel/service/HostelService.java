package com.hostel.service;

import java.util.List;

import com.hostel.model.HostelDTO;

public interface HostelService {
	
	public List<HostelDTO> getHostels() throws Exception;
	
	public HostelDTO getHostelDetails(int hostelId) throws Exception;
	
}
