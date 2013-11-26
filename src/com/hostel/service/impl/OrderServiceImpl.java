package com.hostel.service.impl;

import java.sql.Date;
import java.util.List;

import com.hostel.dao.OrderDAO;
import com.hostel.model.OrderDTO;
import com.hostel.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	OrderDAO orderDAO;

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
	public boolean createOrder(OrderDTO orderDTO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderDTO cancelOrder(int orderId) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
