package com.hostel.dao.impl;

import java.sql.Date;
import java.util.List;

import com.hostel.dao.BedCostDAO;
import com.hostel.dao.rowmapper.BedCostRowMapper;
import com.hostel.model.BedCostDTO;
import com.hostel.model.BedDTO;

public class BedCostDAOImpl extends GenericDAO implements BedCostDAO  {

	private BedCostRowMapper bedCostRowMapper;
	
	@Override
	public boolean insertBedCosts(List<BedCostDTO> bedCostDTOs, int bedId) throws Exception {		
		boolean result = true;
		StringBuilder valuesStr = new StringBuilder();
		StringBuilder valuesStr1 = new StringBuilder();
		valuesStr1.append(insertBedCostsQuery);
		
		for(BedCostDTO bedCostDTO: bedCostDTOs){				
			valuesStr.append(",").append("(").append(bedId).append(",").append(bedCostDTO.getDateRange1Str()).append(",").
			append(bedCostDTO.getDateRange1Str()).append(",").append(bedCostDTO.getBedCost()).append(")");
		}
		
		String insertQuery = valuesStr1.toString()+valuesStr.toString().replaceFirst(",", " ");
		try{
			
			oldJdbcTemplate.update(insertQuery);
			
		}catch (Exception e) {
			
			throw new Exception(e.getMessage(), e);
		}
			
		return result;
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
