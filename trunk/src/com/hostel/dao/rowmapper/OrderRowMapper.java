package com.hostel.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


import com.hostel.model.BedCostDTO;
import com.hostel.model.OrderBedDTO;
import com.hostel.model.OrderDTO;

public class OrderRowMapper  extends GenericRowMapper<OrderDTO> {

	@Override
	public OrderDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		 this.initColumnNames(rs);
		 OrderDTO dto = new OrderDTO();
		 
		 dto.setOrderId(rs.getInt("order_id"));
		 
		 if( this.columns.contains("hostel_id")){
			 dto.setHostelId(rs.getInt("hostel_id"));
		 }
		 if( this.columns.contains("emailId")){
			 dto.setEmailId(rs.getString("emailId"));
		 }
		 if( this.columns.contains("order_cost"))
			 dto.setOrderCost(rs.getFloat("order_cost"));
		 if( this.columns.contains("order_cancel_amt"))
			 dto.setOrderCancelAmt(rs.getFloat("order_cancel_amt"));
		 if( this.columns.contains("order_cancel_date"))
			 dto.setOrderCancelDate(rs.getDate("order_cancel_date"));
		 if( this.columns.contains("order_placed_date"))
		 		 dto.setOrderPlcdDate(rs.getDate("order_placed_date"));
		 if( this.columns.contains("order_start_date"))
		 	dto.setOrderStartDate(rs.getDate("order_start_date"));
		 if( this.columns.contains("order_end_date"))
			 dto.setOrderEndDate(rs.getDate("order_end_date"));		 
		 if( this.columns.contains("hostel_name"))
		 	dto.setHostelName(rs.getString("hostel_name"));
		 if( this.columns.contains("first_name"))
			 dto.setCustomerName(rs.getString("first_name")+rs.getString("last_name")); 
		//cancellation_hours_limit cancellation_fee_percant
		 if( this.columns.contains("cancellation_hours_limit"))
			 dto.setOrderCancellationHoursLimit(rs.getInt("cancellation_hours_limit"));
		 if( this.columns.contains("cancellation_fee_percant"))
			 dto.setCancellationFeePercant(rs.getInt("cancellation_fee_percant"));
		 
		return dto;
	}

}
