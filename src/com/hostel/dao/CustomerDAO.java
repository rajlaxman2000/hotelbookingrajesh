package com.hostel.dao;

import java.util.List;

import com.hostel.model.CustomerDTO;

public interface CustomerDAO {
	
	/*customer_id,first_name,last_name,email,cc_number,expiration_date,security_code,phone*/
	
	public CustomerDTO getCutomerDetailsById(int custId) throws Exception;
	
	public List<CustomerDTO> searchCutomer(String firstName, String lastName, String email) throws Exception;
	
	public int insertCustomer(CustomerDTO customerDTO) throws Exception;
	
	public boolean editCustomer(CustomerDTO customerDTO) throws Exception;
	
	/*customer columns : first_name last_name email , cc_number expiration_date security_code phone
	*/
	public final String getCustByIdQuery="select * from customer where customer_id=:customerId";
	
	//TODO : build complete query based on search items
	public final String searchCustomerQuery="select * from customer where ";
	

	//TODO : build complete parms directly 
	public final String insertQuery="insert into customer (first_name, last_name, email, cc_number, expiration_date, security_code, phone) values " +
			"(:firstName,:lastName,:emailId,:ccNumber,:expDate,:securityCode,:phone)   ";
	

}
