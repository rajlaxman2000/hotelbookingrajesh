package com.hostel.service;

import java.sql.Date;
import java.util.List;

import com.hostel.model.OrderDTO;

public interface OrderService {
	
	public OrderDTO getOrderDetailsByOrderId(int orderId) throws Exception;
	
	public List<OrderDTO> getOrdersByDateRangeCustEmail(Date date1, Date date2, String emailId) throws Exception;
	
	public List<OrderDTO> getOrdersByHostelDateRange(int hostelId, Date startDate, Date endDate) throws Exception;
	
	public List<OrderDTO> getOrdersByHostelBedDateRange(int hostelId, int bedId, Date startDate, Date endDate) throws Exception;
	
	public List<OrderDTO> getOrdersByCustomerId(int custId) throws Exception;
	
	public int createOrder(OrderDTO orderDTO) throws Exception;
	
	public OrderDTO cancelOrder(OrderDTO orderDTO, int canHrs) throws Exception;
	
	public float calculateCancellationAmt(int HostelId, float orderAmt) throws Exception;
}
