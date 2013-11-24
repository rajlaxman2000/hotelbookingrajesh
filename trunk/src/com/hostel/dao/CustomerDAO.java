package com.hostel.dao;

import com.hostel.model.CustomerDTO;

public interface CustomerDAO {
	
	/*customer_id,first_name,last_name,email,cc_number,expiration_date,security_code,phone*/
	
	public CustomerDTO getCutomerDetailsById(int custId);
	
	/**
	 * This method returns custId if the cutomer exists with given details
	 * other wise it will return 0 in place of CustId
	 * 
	 * @param emailFaceBookTwitterId
	 * @return
	 */
	public CustomerDTO searchCutomer(String email);
	
	public int insertCustomer(CustomerDTO customerDTO);
	
	
	public final String getCustByIdQuery="select * from customer where customer_id=:customerId";
	
	//TODO : build complete query based on search items
	public final String searchCustomerQuery="select customer_id from customer where  ";
	
	//TODO : build complete parms directly 
	public final String insertQuery="insert into ";
	
	///TODO :  build query complete based on parms given to be updated.
	public final String updateQuery="update customer ";
	

}
