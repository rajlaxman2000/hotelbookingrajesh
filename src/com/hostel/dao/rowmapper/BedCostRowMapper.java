package com.hostel.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.hostel.model.BedCostDTO;

public class BedCostRowMapper extends GenericRowMapper<BedCostDTO> {

	@Override
	public BedCostDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		this.initColumnNames(rs);
		BedCostDTO dto = new BedCostDTO();
		dto.setBedId(rs.getInt("bed_id"));
		dto.setBedCost(rs.getInt("bed_cost"));
		dto.setDateRange1(rs.getDate("date_range1"));
		dto.setDateRange2(rs.getDate("date_range2"));		
		return dto;
	}

}
