package com.hostel.dao;

import com.hostel.model.CustomerDTO;

public interface CustomerDAO {
	
	public CustomerDTO getCutomerDetailsById(int custId);
	
	/**
	 * This method returns custId if the cutomer exists with given details
	 * other wise it will return 0 in place of CustId
	 * 
	 * @param emailFaceBookTwitterId
	 * @return
	 */
	public int searchCutomer(String emailFaceBookTwitterId);
	
	public int insertCustomer(CustomerDTO customerDTO);
	
	
	public final String getCustByIdQuery="select * from customer where customer_id=:customerId";
	
	public final String searchCustomerQuery="select customer_id from customer where  ";
	
	public final String insertQuery="";
	
	/* 
`customer_id, customer_name, cuttomer_age, customer_gender,
  `customer_facebookId` varchar(45) DEFAULT NULL,
  `customer_emailId` varchar(45) DEFAULT NULL,
  `customer_twitterId` varchar(45) DEFAULT NULL,
  `customer_address_id` bigint(20) DEFAULT NULL,
	 */
}
