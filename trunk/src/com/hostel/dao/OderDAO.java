package com.hostel.dao;

import com.hostel.model.OrderDTO;

public interface OderDAO {
	
	public boolean insertOder(OrderDTO orderDTO); 
			
	public boolean cancelOrder(OrderDTO orderDTO);
	
	public OrderDTO getOrderDetailsByOrderId(int orderId);
	
	public OrderDTO getOrderDetailsByCutId(int custId);

	
	/**
	 * Oder Table : oder_id, cutomerId, hostel_id, Order_cost, order_cancel_amt, oder_cancel_date,
	 * order_placed_date, order_start_date, order_end_date
	 * `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` bigint(20) NOT NULL,
  `hostel_id` int(11) NOT NULL,
  `order_cost` decimal(4,2) DEFAULT '0.00',
  `order_cancel_amt` decimal(4,2) DEFAULT '0.00',
  `oder_cancel_date` datetime DEFAULT NULL,
  `order_placed_date` datetime DEFAULT NULL,
  `order_start_date` datetime DEFAULT NULL,
  `order_end_date` datetime DEFAULT NULL, 
	 */
	
}
