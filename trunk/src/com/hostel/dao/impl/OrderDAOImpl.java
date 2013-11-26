package com.hostel.dao.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.hostel.dao.OrderDAO;
import com.hostel.dao.rowmapper.OrderRowMapper;
import com.hostel.model.HostelDTO;
import com.hostel.model.OrderBedDTO;
import com.hostel.model.OrderDTO;
import com.hostel.model.RevenueDTO;

public class OrderDAOImpl extends GenericDAO implements OrderDAO {
	
	OrderRowMapper  orderRowMapper;
	

	@Override
	public List<OrderDTO> getOrdersForSearchService(int hostelId, int bedId,Date givenStartDate, Date givenEndDate) throws Exception {
		
		List<OrderDTO> orders =null;
		Map<String, Object> paramMap = new HashMap<String, Object>(4);	
		
		paramMap.put("bedId",new Integer(bedId));
		paramMap.put("hostelId",new Integer(hostelId));
		paramMap.put("givenStartDate",givenStartDate);
		paramMap.put("givenEndDate",givenEndDate);
		
		try {
			orders = jdbcTemplate.query(getOrdersForSearchServiceQuery, paramMap, orderRowMapper);
		} catch(DataAccessException e) {
			throw new Exception(e.getMessage(), e);
		}
		
		return orders;
	}

	@Override
	public List<OrderDTO> searchOrdersForViewByDatesEmial(Date givenStartDate,
			Date givenEndDate, String userEmail) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> getCompleteOrderDetailsById(int orderId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOrder(OrderDTO orderDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertOrdersBed(OrderBedDTO orderBedDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderDTO cancelOrder(OrderDTO orderDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderBedDTO> getOrderBeds(int orderId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RevenueDTO> getRevenueByDates(Date date1, Date daate2)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the orderRowMapper
	 */
	public OrderRowMapper getOrderRowMapper() {
		return orderRowMapper;
	}

	/**
	 * @param orderRowMapper the orderRowMapper to set
	 */
	public void setOrderRowMapper(OrderRowMapper orderRowMapper) {
		this.orderRowMapper = orderRowMapper;
	}
	
	

}
