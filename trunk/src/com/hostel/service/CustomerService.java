package com.hostel.service;

import java.util.List;

import com.hostel.model.CustomerDTO;

public interface CustomerService {
	
	
	
	public List<CustomerDTO> searchCustomerByCriteria(String firstName, String lastName, String email) throws Exception;
	
	public CustomerDTO addCustomer(CustomerDTO DTO) throws Exception;
	
	public CustomerDTO updateCustomer(CustomerDTO DTO) throws Exception;

}
