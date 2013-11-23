package com.hostel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import com.hostel.dao.BedDAO;
import com.hostel.model.BedDTO;


public class BedDAOImpl extends GenericDAO implements BedDAO {
	
	private BedRowMapper bedRowMapper;

	@Override
	public List<BedDTO> getBedsByRoomId(int roomId) throws Exception {
		List<BedDTO> beds =null;
		Map<String, Object> paramMap = new HashMap<String, Object>(2);
		paramMap.put("roomId", roomId);
		try{
			beds = jdbcTemplate.query(getBedsQuery, paramMap, bedRowMapper);
		} catch(DataAccessException e) {
			throw new Exception(e.getMessage(), e);
		}
		
		return beds;
	}

	@Override
	public BedDTO getBedDetailsByBedId(int bedId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBed(BedDTO bedDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertBed(BedDTO bedDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the bedRowMapper
	 */
	public BedRowMapper getBedRowMapper() {
		return bedRowMapper;
	}

	/**
	 * @param bedRowMapper the bedRowMapper to set
	 */
	public void setBedRowMapper(BedRowMapper bedRowMapper) {
		this.bedRowMapper = bedRowMapper;
	}
	

}
