package com.hostel.dao.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.dao.DataAccessException;


import com.hostel.dao.BedCostDAO;

import com.hostel.dao.rowmapper.BedCostRowMapper;
import com.hostel.model.BedCostDTO;
import com.hostel.model.BedDTO;


public class BedCostDAOImpl extends GenericDAO implements BedCostDAO  {

	private BedCostRowMapper bedCostRowMapper;
	
	//where h.hostel_id=:hostelId and bc.date_range1>=Date('2014-01-07') and (bc.date_range1<=Date('2014-02-01') or bc.date_range2<Date('2014-02-01'))
	public List<BedCostDTO> getBedCostDTOsByDatesForSearch(int hostelId,Date date1, Date date2) throws Exception{
		List<BedCostDTO> bedCosts=null;		
		Map<String, Object> paramMap = new HashMap<String, Object>(3);
		StringBuilder qryStr = new StringBuilder(searchBedCostForSearchQuery);
		qryStr.append(" and bc.date_range1>=:date1 and (bc.date_range1<=:date2 or bc.date_range2<:date2)");
		paramMap.put("hostelId", hostelId);
		paramMap.put("date1", date1);
		paramMap.put("date2", date2);
		try{
			bedCosts = jdbcTemplate.query(qryStr.toString(), paramMap, bedCostRowMapper);
		} catch(DataAccessException e) {
			throw new Exception(e.getMessage(), e);
		}
		return bedCosts;
	}

	public List<BedCostDTO> getBedCostDTOsByForSearch(int hostelId) throws Exception{
		List<BedCostDTO> bedCosts=null;
		Map<String, Object> paramMap = new HashMap<String, Object>(1);
		paramMap.put("hostelId", hostelId);
		try{
			bedCosts = jdbcTemplate.query(searchBedCostForSearchQuery, paramMap, bedCostRowMapper);
		} catch(DataAccessException e) {
			throw new Exception(e.getMessage(), e);
		}
		
		return bedCosts;
	}
	
	//where h.hostel_id=:hostelId and bc.date_range1>=Date('2014-01-07') and (bc.date_range1<=Date('2014-02-01') or bc.date_range2<Date('2014-02-01'))
	@Override
	public boolean insertBedCost(BedCostDTO bedCostDTO, int bedId) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bedId", bedId);
		paramMap.put("dateRange1", bedCostDTO.getDateRange1());
		paramMap.put("dateRange2", bedCostDTO.getDateRange2());
		paramMap.put("bedCost", bedCostDTO.getBedCost());
		try{
			jdbcTemplate.update(insertBedCostQuery,paramMap);
		} catch(DataAccessException e) {
			throw new Exception(e.getMessage(), e);
		}
		return true;
		
	}

	@Override
	public List<BedDTO> getBedsByRoomId(int roomId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BedCostDTO> getBedCostDetailsByBedId(int bedId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
	 * @return the bedCostRowMapper
	 */
	public BedCostRowMapper getBedCostRowMapper() {
		return bedCostRowMapper;
	}
	
	/**
	 * @param bedCostRowMapper the bedCostRowMapper to set
	 */
	public void setBedCostRowMapper(BedCostRowMapper bedCostRowMapper) {
		this.bedCostRowMapper = bedCostRowMapper;
	}


	

}
