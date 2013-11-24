package com.hostel.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.hostel.model.HostelDTO;

public class HostelRowMapper extends GenericRowMapper<HostelDTO> {
	/*
	 * hostel_name, hostel_street, hostel_city, hostel_state, hostel_postal_code, hostel_country, hostel_phone,hostel_email, 
	 * hostel_facebook,   hostel_web,  hostel_checkIn_time,  hostel_checkOut_time,  smoking,  alcohol, cancellation_hours_limit,
	 *  cancellation_fee_percant
	 *  */
	@Override
	public HostelDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		this.initColumnNames(rs);
		HostelDTO dto = new HostelDTO();
		dto.setHostelId(rs.getInt("hostel_id"));
		dto.setHostelName(rs.getString("hostel_name"));
		//This logic sperates that either we will just pull out id and name to use for light use or will pull complete data for heavy use 
		if(rs.getString("hostel_street")!=null){
			dto.setAdrStreet(rs.getString("hostel_street"));
			dto.setAdrCity(rs.getString("hostel_city"));
			dto.setAdrState(rs.getString("hostel_state"));
			dto.setAdrPostalCode(rs.getString("hostel_postal_code"));
			dto.setAdrCountry(rs.getString("hostel_country"));
			dto.setPhone(rs.getString("hostel_phone"));
			dto.setEmail(rs.getString("hostel_email"));
			dto.setFacebook(rs.getString("hostel_facebook"));
			dto.setWeb(rs.getString("hostel_facebook"));
			
			dto.setCheckInTime(rs.getString("hostel_checkIn_time"));
			dto.setCheckOutTime(rs.getString("hostel_checkOut_time"));
			dto.setSmoking(rs.getString("smoking"));
			dto.setAlcohol(rs.getString("alcohol"));
			dto.setOrderCancellationHoursLimit(rs.getInt("cancellation_hours_limit"));
			dto.setCancellationFeePercant(rs.getInt("cancellation_fee_percant"));
		}
		return dto;
	}		
}
