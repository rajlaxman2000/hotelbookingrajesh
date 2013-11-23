package com.hostel.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.hostel.model.HostelDTO;

public class HostelRowMapper extends GenericRowMapper<HostelDTO> {

	@Override
	public HostelDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		this.initColumnNames(rs);
		HostelDTO dto = new HostelDTO();
		dto.setHostelId(rs.getInt("hostel_id"));
		dto.setHostelName(rs.getString("hostel_name"));
		/*
		if(this.columns.contains("hostel_city")) {
			dto.setHostelCity(rs.getString("hostel_city"));
		}		
		if(this.columns.contains("hostel_country")) {
			dto.setHostelCountry(rs.getString("hostel_country"));
		}
		if(this.columns.contains("cancellation_days_limit")) {
			dto.setOrderCancellationDaysLimit(rs.getInt("cancellation_days_limit"));
		}
		if(this.columns.contains("cancellation_fee_percant")) {
			dto.setCancellationFeePercant(rs.getInt("cancellation_fee_percant"));			
		}
			*/
		return dto;
	}		
}
