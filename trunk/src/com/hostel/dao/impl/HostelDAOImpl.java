package com.hostel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import com.hostel.dao.HostelDAO;
import com.hostel.model.HostelDTO;

public class HostelDAOImpl extends GenericDAO implements HostelDAO{

	private HostelRowMapper hostelRowMapper;
	
	/*
	 * (non-Javadoc)
	 * @see com.hostel.dao.HostelDAO#getAllHostels()
	 */
	@Override
	public List<HostelDTO> getAllHostels() throws Exception {
		List<HostelDTO> hostels = null;
		Map<String, Object> paramMap = new HashMap<String, Object>(2);
		//paramMap.put(ContactLogTable.ACCOUNT_NUM, loanId);
		try {
			hostels = jdbcTemplate.query(getHostelsQuery, paramMap, hostelRowMapper);
		} catch(DataAccessException e) {
			throw new Exception(e.getMessage(), e);
		}

		return hostels;
	}

	@Override
	public HostelDTO getHostelDetailsById(int hostelId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the hostelRowMapper
	 */
	public HostelRowMapper getHostelRowMapper() {
		return hostelRowMapper;
	}

	/**
	 * @param hostelRowMapper the hostelRowMapper to set
	 */
	public void setHostelRowMapper(HostelRowMapper hostelRowMapper) {
		this.hostelRowMapper = hostelRowMapper;
	}
	

	
	

}
