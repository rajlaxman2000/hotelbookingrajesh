package com.hostel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.hostel.dao.BedDAO;
import com.hostel.dao.rowmapper.BedRowMapper;
import com.hostel.model.BedDTO;


public class BedDAOImpl extends GenericDAO implements BedDAO {
	
	private BedRowMapper bedRowMapper;

	@Override
	public List<BedDTO> getBedsByRoomId(int roomId) throws Exception {
		List<BedDTO> beds =null;
		Map<String, Object> paramMap = new HashMap<String, Object>(2);
		paramMap.put("roomId", roomId);
		
		try{
			SqlParameterSource namedParameters = new MapSqlParameterSource(paramMap);
			KeyHolder keyHolder = new GeneratedKeyHolder();
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

	@Override
	public int updateBed(BedDTO bedDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertBed(BedDTO bedDTO, int roomId) throws Exception {		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bedName", bedDTO.getBedName());
		paramMap.put("roomId", roomId);		
		Number bedId;		
		try{
			 SqlParameterSource namedParameters = new MapSqlParameterSource(paramMap);
			 KeyHolder keyHolder = new GeneratedKeyHolder();
			 jdbcTemplate.update(insertBedQuery, namedParameters,keyHolder);
			 bedId = keyHolder.getKey();
			 
		} catch(DataAccessException e) {
			throw new Exception(e.getMessage(), e);
		}
		return bedId.intValue();
	}


	

}
