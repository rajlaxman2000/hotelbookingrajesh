package com.hostel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.hostel.dao.HostelDAO;
import com.hostel.dao.rowmapper.HostelRowMapper;
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

	@Override
	public int insertHostel(HostelDTO hostelDTO) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap = buildParamsMap(paramMap, hostelDTO);
		Number hostelId;	
		try{
			SqlParameterSource namedParameters = new MapSqlParameterSource(paramMap);
			
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(insertHostelQuery, namedParameters,keyHolder);
			hostelId = keyHolder.getKey();
		} catch(DataAccessException e) {
			throw new Exception(e.getMessage(), e);
		}
		return hostelId.intValue();
	}
	
	private Map<String,Object> buildParamsMap(Map<String, Object> map, HostelDTO hostelDTO){
		/*
		 * :hostelName,:adrStreet,:adrCity,:adrState," +
			":adrPostalCode,:adrCountry,:phone,:email,:facebook,:web,:checkInTime,:checkOutTime,:smoking,:alcohol,:orderCancellationHoursLimit,:cancellationFeePercant)";
		 */
		map.put("hostelName", hostelDTO.getHostelName());
		map.put("adrStreet", hostelDTO.getAdrStreet());
		map.put("adrCity", hostelDTO.getAdrCity());
		map.put("adrState", hostelDTO.getAdrState());
		map.put("adrPostalCode", hostelDTO.getAdrPostalCode());
		map.put("adrCountry", hostelDTO.getAdrCountry());
		map.put("phone", hostelDTO.getPhone());
		map.put("email", hostelDTO.getEmail());
		map.put("facebook", hostelDTO.getFacebook());
		map.put("web", hostelDTO.getWeb());
		map.put("checkInTime", hostelDTO.getCheckInTime());
		map.put("checkOutTime", hostelDTO.getCheckOutTime());
		map.put("smoking", hostelDTO.getSmoking());
		map.put("alcohol", hostelDTO.getAlcohol());
		map.put("orderCancellationHoursLimit", hostelDTO.getOrderCancellationHoursLimit());
		map.put("cancellationFeePercant", hostelDTO.getCancellationFeePercant());
		return map;
	}
	
	

}
