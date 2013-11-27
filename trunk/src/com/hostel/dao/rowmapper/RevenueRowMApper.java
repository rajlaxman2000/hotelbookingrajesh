package com.hostel.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hostel.model.OrderDTO;
import com.hostel.model.RevenueDTO;

public class RevenueRowMApper extends GenericRowMapper<RevenueDTO> {

	@Override
	public RevenueDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		 this.initColumnNames(rs);
		 RevenueDTO dto = new RevenueDTO();
		 
		 dto.setTotalOrdersRevenue(rs.getFloat("order_amount"));
		 dto.setTotalCancelAmount(rs.getFloat("cancelled_amount"));
		 dto.setTotalGeneratedRevenue(dto.getTotalOrdersRevenue()-dto.getTotalCancelAmount());
		
		return dto;
	}
	

}
