package com.hostel.service;

import java.util.Date;
import java.util.List;

import com.hostel.model.OrderDTO;

public interface OrderService {
	
	public List<OrderDTO> getOrdersByHostelDateRange(int hostelId, Date startDate, Date endDate);
	
	public List<OrderDTO> getOrdersByCustomerId(int custId);
	
	public boolean createOrder(OrderDTO orderDTO);
	
	public OrderDTO cancelOrder(int orderId);
	
	public float calculateCancellationAmt(int HostelId, float orderAmt);
}
