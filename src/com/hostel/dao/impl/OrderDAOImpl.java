package com.hostel.dao.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.hostel.dao.OrderDAO;
import com.hostel.dao.rowmapper.OrderRowMapper;
import com.hostel.model.CustomerDTO;
import com.hostel.model.HostelDTO;
import com.hostel.model.OrderBedDTO;
import com.hostel.model.OrderDTO;
import com.hostel.model.RevenueDTO;

public class OrderDAOImpl extends GenericDAO implements OrderDAO {
	
	OrderRowMapper  orderRowMapper;
	
	@Override
	public List<OrderDTO> getAllOrdersByForView(Date date1, Date date2, String custEmailId) throws Exception {
		String emailClause;
		List<OrderDTO> orders=null;
		if(custEmailId!=null && custEmailId.length()>0){			
			emailClause = new String(" or c.emailId like'%"+custEmailId+"%'");
		}else{
			emailClause =new String(" ");
		}
		
		Map<String, Object> paramMap = new HashMap<String, Object>(1);
		paramMap.put("date1", date1);
		paramMap.put("date2", date2);
		paramMap.put("emailId", custEmailId);
		
		try {
			orders = jdbcTemplate.query(getAllOrdersByForViewQry+emailClause, paramMap, orderRowMapper);
		} catch(DataAccessException e) {
			throw new Exception(e.getMessage(), e);
		}
		
		
		return (orders!=null && orders.size()>0)?orders:null;
	}
	
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
	public List<OrderDTO> getCompleteOrderDetailsById(int orderId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertOrder(OrderDTO orderDTO) throws Exception {
		//(:customerId,:hostelId,:OrderCost,CURDATE(),:OrderStartDate,:OrderEndDate,1)";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Number orderId;
		paramMap.put("customerId", orderDTO.getCustomerId());
		paramMap.put("hostelId", orderDTO.getHostelId());
		paramMap.put("OrderCost", orderDTO.getOrderCost());
		paramMap.put("OrderStartDate", orderDTO.getOrderStartDate());
		paramMap.put("OrderEndDate", orderDTO.getOrderEndDate());
		SqlParameterSource namedParameters = new MapSqlParameterSource(paramMap);			
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(insertOrderQry, namedParameters,keyHolder);
		orderId = keyHolder.getKey();
		
		return orderId.intValue();
	}
	
	//private Map<String,Object> buildParamsMap(Map<String, Object> map, CustomerDTO customerDTO){
	private Map<String,Object> buildParamsMap(Map<String, Object> map, OrderDTO orderDTO){
		
	return null;	
	}

	@Override
	public int insertOrdersBed(OrderBedDTO orderBedDTO) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Number orderBedId;
		paramMap.put("orderId", orderBedDTO.getOrderId());
		paramMap.put("bedId", orderBedDTO.getBedId());
		
		SqlParameterSource namedParameters = new MapSqlParameterSource(paramMap);			
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(insertOrdersBedQry, namedParameters,keyHolder);
		orderBedId = keyHolder.getKey();
		
		return orderBedId.intValue();
	}

	@Override
	public boolean cancelOrder(OrderDTO orderDTO) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orderCanAmt", orderDTO.getOrderCancelAmt());
		paramMap.put("orderId", orderDTO.getOrderId());
		jdbcTemplate.update(cancelOrderQry.toString(), paramMap);
		return true;
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
