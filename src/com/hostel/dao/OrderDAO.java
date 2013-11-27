package com.hostel.dao;

import java.sql.Date;
import java.util.List;

import com.hostel.model.OrderBedDTO;
import com.hostel.model.OrderDTO;
import com.hostel.model.RevenueDTO;

public interface OrderDAO {
	
	// Orders table Columns : order_id customer_id hostel_id order_cost order_cancel_amt 
	//		order_cancel_date order_placed_date order_start_date order_end_date active
	//Order bed Columns :  order_bed_id order_id bed_id start_date end_date
	
	public List<OrderDTO> getAllOrdersByForView(Date date1, Date date2, String custEmailId) throws Exception;
	
	public List<OrderDTO> getOrdersForSearchService(int hostelId, int bedId, Date givenStartDate, Date givenEndDate) throws Exception;
	
	public List<OrderDTO> searchOrdersForViewByDatesEmial(Date givenStartDate, Date givenEndDate,String userEmail) throws Exception;
	
	public List<OrderDTO> getCompleteOrderDetailsById(int orderId) throws Exception;
	
	// write method to pull the total order revenue, cancel amount,
	
	public int insertOrder(OrderDTO orderDTO) throws Exception;
	
	public int insertOrdersBed(OrderBedDTO orderBedDTO) throws Exception;
	
	public boolean cancelOrder(OrderDTO orderDTO) throws Exception;
	
	public List<OrderBedDTO> getOrderBeds(int orderId) throws Exception;
	
	public List<RevenueDTO> getRevenueByDates(Date date1, Date daate2) throws Exception;
	
	public static final String getAllOrdersByForViewQry ="select o.order_id,o.hostel_id, o.order_cost,o.order_placed_date, o.order_cancel_amt, " +
			" o.order_cancel_date, o.order_start_date, o.order_end_date, c.emailId  from orders o" +
			" inner join customer c on c.customer_id = o.customer_id" +
			" where (:givenStartDate<=o.order_start_date and o.order_start_date<=:givenEndDate " +
			" and :givenStartDate<=o.order_end_date and o.order_end_date<=:givenEndDate) ";
	
	
	
	public static final String cancelOrderQry = "update order set order_cancel_amt=:orderCanAmt, order_cancel_date = CURDATE(), active=0 where order_id=:orderId";
	
	public static final String insertOrdersBedQry = "insert into order_bed (order_id, bed_id) values (:orderId,:bedId)";
	///// Orders table Columns : order_id customer_id hostel_id order_cost order_cancel_amt 
	//		order_cancel_date order_placed_date order_start_date order_end_date active
	//Order bed Columns :  order_bed_id order_id bed_id start_date end_date
	public static final String insertOrderQry = "insert into orders (customer_id,hostel_id,order_cost,order_placed_date,order_start_date" +
			", order_end_date,active) values (:customerId,:hostelId,:OrderCost,CURDATE(),:OrderStartDate,:OrderEndDate,1)";
	
	public static final String getRevenueByDatesQuery ="select sum(order_cost) as orderAmt, sum(order_cancel_amt) as canAmt from orders " +
			" where :givenStartDate<=order_start_date and  order_end_date<=:givenEndDate";
	
	/*
	 (:givenStartDate<=order_start_date and order_start_date<=:givenEndDate) or (:givenStartDate<=order_end_date and order_end_date<=:givenEndDate)
				or (order_start_date<=:givenStartDate and order_end_date>=:givenEndDate) 
				bedId,hostelId,givenStartDate,givenEndDate
	 */	
	public static final String getOrdersForSearchServiceQuery = "select distinct(o.order_id) from orders o" +
			" inner join order_bed ob on o.order_id = ob.order_id" +
			" where o.hostel_id=:hostelId and ob.bed_id=:bedId and " +
			" ((:givenStartDate<=order_start_date and order_start_date<=:givenEndDate) or" +
			"  (:givenStartDate<=order_end_date and order_end_date<=:givenEndDate) or " +
			"  (order_start_date<=:givenStartDate and order_end_date>=:givenEndDate)) ";
	
	
	public static final String searchOrdersForViewByDatesEmialQuery = "select o.order_id from orders o"+	
					"inner join order_bed ob on o.order_id = ob.order_id" +			
					"inner join customer c on c.customer_id=o.customer_id" +
					"where c.customer_email like '%:emailId%' and (:givenStartDate<=order_start_date and  order_end_date<=:givenEndDate) ";
	 
	public static final String getCompleteOrderDetailsByIdQuery="select o.order_id, h.hostel_name, o.order_cost, o.order_cancel_amt,  " +
			"o.order_start_date, o.order_start_date, c.first_name, c.last_name from orders, count(ob.bed_id) as noofbeds o" +
			"inner join order_bed ob on o.order_id = ob.order_id" +			
			"inner join customer c on c.customer_id=o.customer_id" +
			"inner join hostel h on h.hostel_id = o.hostel_id"+
			"where o.order_id=:orderId";
			

	
	
	
}
