package com.hostel.service.impl;

import java.sql.Date;
import java.util.List;

import com.hostel.dao.HostelDAO;
import com.hostel.dao.OrderDAO;
import com.hostel.model.OrderBedDTO;
import com.hostel.model.OrderDTO;
import com.hostel.model.RevenueDTO;
import com.hostel.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	OrderDAO orderDAO;
	
	

	@Override
	public RevenueDTO getRevenueByDates(Date date1, Date date2) throws Exception {
		List<RevenueDTO> dtos=null;
		try{
			dtos = orderDAO.getRevenueByDates(date1, date2);
		}catch (Exception e) {
			throw new Exception(e.getMessage(), e); 
		}		
		return (dtos!=null && dtos.size()>0)?dtos.get(0):null;
	}
	
	@Override
	public OrderDTO cancelOrder(OrderDTO orderDTO, int canBeforeHrs) throws Exception {
		OrderDTO returnOrderDTO =null;
		// find the cancell amont based on the hrs passed by checking with hostel details
		float canAmt=0;
		int canPercant = orderDTO.getCancellationFeePercant();
		float orderCost = orderDTO.getOrderCost();
		if(canBeforeHrs==0 || canBeforeHrs>orderDTO.getOrderCancellationHoursLimit()){
			orderDTO.setOrderCancelAmt(orderDTO.getOrderCost());
		}else if(canBeforeHrs<=orderDTO.getOrderCancellationHoursLimit() ){
			canAmt = (orderCost * (100-canPercant))/100;
			orderDTO.setOrderCancelAmt(canAmt);
		}
		//check it and set it to order dto so that dao wlayer will use it directly 
		
		if(orderDAO.cancelOrder(orderDTO)){
			returnOrderDTO = orderDTO;
		}
			
		return returnOrderDTO;
	}

	
	@Override
	public OrderDTO getOrderDetailsByOrderId(int orderId) throws Exception{
		List<OrderDTO> orders = null;
		orders = orderDAO.getCompleteOrderDetailsById(orderId);
		if(orders!=null){
			orders.get(0).setNoOfBeds(orders.size());
		}
		return (orders!=null && orders.size()>0)?orders.get(0):null;
	}
	
	@Override
	public List<OrderDTO> getOrdersByDateRangeCustEmail(Date date1, Date date2, String emailId) throws Exception {
		List<OrderDTO> orderDTOs=null;
		try {
			orderDTOs = orderDAO.getAllOrdersByForView(date1, date2, emailId);
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
		
		return orderDTOs;
	}

	

	@Override
	public List<OrderDTO> getOrdersByHostelDateRange(int hostelId, Date startDate, Date endDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> getOrdersByHostelBedDateRange(int hostelId, int bedId, Date startDate, Date endDate) throws Exception {
			List<OrderDTO> orders;
			orders = orderDAO.getOrdersForSearchService(hostelId, bedId, startDate, endDate);
		return orders;
	}

	@Override
	public List<OrderDTO> getOrdersByCustomerId(int custId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createOrder(OrderDTO orderDTO) throws Exception {
		int orderId=0;
		try{			
			orderId  = orderDAO.insertOrder(orderDTO);
			if(orderId!=0){
				for(OrderBedDTO orderBedDTO : orderDTO.getOrderBeds()){
					orderBedDTO.setOrderId(orderId);
					orderDAO.insertOrdersBed(orderBedDTO);
				}
			}
		}catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}	
		return orderId;
	}



	@Override
	public float calculateCancellationAmt(int HostelId, float orderAmt) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return the orderDAO
	 */
	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	/**
	 * @param orderDAO the orderDAO to set
	 */
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}





	
}
