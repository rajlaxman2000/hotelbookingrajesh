package com.hostel.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hostel.model.CustomerDTO;
import com.hostel.model.RoomDTO;


public class CustomerRowMapper extends GenericRowMapper<CustomerDTO> {

	@Override
	public CustomerDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		this.initColumnNames(rs);
		CustomerDTO dto = new CustomerDTO();
		///*customer columns : first_name last_name email , cc_number expiration_date security_code phone
		
		if(this.columns.contains("customer_id"))
			dto.setCustId(rs.getInt("customer_id"));
		if(this.columns.contains("first_name"))
			dto.setFirstName(rs.getString("first_name"));
		if(this.columns.contains("last_name"))
			dto.setLastName(rs.getString("last_name"));
		if(this.columns.contains("email"))
			dto.setEmailId(rs.getString("email"));
		if(this.columns.contains("cc_number"))
			dto.setCcNumber(rs.getString("cc_number"));
		if(this.columns.contains("expiration_date"))
			dto.setExpDate(rs.getString("expiration_date"));
		if(this.columns.contains("security_code"))
			dto.setSecurityCode(rs.getString("security_code"));
		if(this.columns.contains("phone"))
			dto.setPhone(rs.getString("phone"));
		
				
		return dto;
	}

}
