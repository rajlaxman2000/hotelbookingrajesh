package com.hostel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.hostel.dao.RoomDAO;

import com.hostel.model.RoomDTO;

public class RoomDAOImpl extends GenericDAO implements RoomDAO{

	private RoomRowMapper roomRowMapper;
	
	@Override
	public List<RoomDTO> getRoomsbyHostelId(int hostelId) throws Exception	{
		List<RoomDTO> rooms =null;
		Map<String, Object> paramMap = new HashMap<String, Object>(2);
		paramMap.put("hostelId", hostelId);
		try{
			rooms = jdbcTemplate.query(getRoomsQuery, paramMap, roomRowMapper);
		} catch(DataAccessException e) {
			throw new Exception(e.getMessage(), e);
		}
		
		return rooms;
	}

	@Override
	public RoomDTO getRoomDetailsById(int roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean InsertRoom(RoomDTO roomDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean UpdateRoom(RoomDTO roomDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the roomRowMapper
	 */
	public RoomRowMapper getRoomRowMapper() {
		return roomRowMapper;
	}

	/**
	 * @param roomRowMapper the roomRowMapper to set
	 */
	public void setRoomRowMapper(RoomRowMapper roomRowMapper) {
		this.roomRowMapper = roomRowMapper;
	}
	
	

}
