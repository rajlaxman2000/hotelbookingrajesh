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
		
		if(rs.getInt("customer_id")!=0)
			dto.setCustId(rs.getInt("customer_id"));
		if(rs.getString("first_name")!=null)
			dto.setFirstName(rs.getString("first_name"));
		if(rs.getString("last_name")!=null)
			dto.setLastName(rs.getString("last_name"));
		if(rs.getString("email")!=null)
			dto.setEmailId(rs.getString("email"));
		if(rs.getString("cc_number")!=null)
			dto.setCcNumber(rs.getString("cc_number"));
		if(rs.getString("expiration_date")!=null)
			dto.setExpDate(rs.getString("expiration_date"));
		if(rs.getString("security_code")!=null)
			dto.setSecurityCode(rs.getString("security_code"));
		if(rs.getString("phone")!=null)
			dto.setPhone(rs.getString("phone"));
		
				
		return dto;
	}

}
