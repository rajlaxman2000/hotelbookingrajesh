package com.hostel.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.hostel.model.BedDTO;


public class BedRowMapper  extends GenericRowMapper<BedDTO>{

	@Override
	public BedDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		 this.initColumnNames(rs);
		 BedDTO dto = new BedDTO();
		 dto.setBedId(rs.getInt("bed_id"));
		 dto.setBedName(rs.getString("bed_name"));		 
				  
		return dto;
	}
	
	

}
