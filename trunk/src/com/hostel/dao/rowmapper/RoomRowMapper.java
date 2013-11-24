package com.hostel.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.hostel.model.RoomDTO;

public class RoomRowMapper extends GenericRowMapper<RoomDTO> {

	@Override
	public RoomDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		this.initColumnNames(rs);
		RoomDTO dto = new RoomDTO();
		dto.setRoomId(rs.getInt("room_id"));
		dto.setRoomName(rs.getString("room_name"));
				
		return dto;
	}
	
	

}
