package com.hostel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.hostel.dao.RoomDAO;
import com.hostel.dao.rowmapper.RoomRowMapper;

import com.hostel.model.RoomDTO;

public class RoomDAOImpl extends GenericDAO implements RoomDAO{

	private RoomRowMapper roomRowMapper;
	
	@Override
	public int InsertRoom(RoomDTO roomDTO, int hostelId) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("roomName", roomDTO.getRoomName());
		paramMap.put("hostelId", hostelId);		
		Number roomId;		
		try{
			SqlParameterSource namedParameters = new MapSqlParameterSource(paramMap);
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(insertRoomQuery, namedParameters,keyHolder);
			roomId = keyHolder.getKey();
		} catch(DataAccessException e) {
			throw new Exception(e.getMessage(), e);
		}
		return roomId.intValue();
	}
	
	
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

	

	@Override
	public boolean UpdateRoom(RoomDTO roomDTO, int hostelId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
