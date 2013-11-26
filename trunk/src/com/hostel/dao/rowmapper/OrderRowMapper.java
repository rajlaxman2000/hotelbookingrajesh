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
		 if( this.columns.contains("order_cost"))
			 dto.setOrderCost(rs.getInt("order_cost"));
		 if( this.columns.contains("order_cancel_amt"))
			 dto.setOrderCancelAmt(rs.getInt("order_cancel_amt"));
		 if( this.columns.contains("order_cancel_date"))
			 dto.setOrderCancelDate(rs.getDate("order_cancel_date"));
		 if( this.columns.contains("order_placed_date"))
		 		 dto.setOrderPlcdDate(rs.getDate("order_placed_date"));
		 if( this.columns.contains("order_start_date"))
		 	dto.setOrderStartDate(rs.getDate("order_start_date"));
		 if( this.columns.contains("order_end_date"))
			 dto.setOrderEndDate(rs.getDate("order_end_date"));
		 if( this.columns.contains("noofbeds"))
			 dto.setNoOfBeds(rs.getInt("noofbeds"));
		 if( this.columns.contains("hostel_name"))
		 	dto.setHostelName(rs.getString("hostel_name"));
		 if( this.columns.contains("first_name"))
			 dto.setCustomerName(rs.getString("first_name")+rs.getString("last_name")); 
		
		return dto;
	}

}
