package com.hostel.service.impl;

import java.util.List;

import com.hostel.dao.CustomerDAO;
import com.hostel.model.CustomerDTO;
import com.hostel.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	CustomerDAO customerDAO;
	
	
	
	
	@Override
	public List<CustomerDTO> searchCustomerByCriteria(String firstName, String lastName, String email) throws Exception {
		
		List<CustomerDTO> customerDTOs = null;
		try {
			customerDTOs = customerDAO.searchCutomer(firstName,lastName,email);	
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
		return customerDTOs;
	}

	@Override
	public CustomerDTO addCustomer(CustomerDTO customerDTO) throws Exception {// TODO Auto-generated method stub
		int custId=0;
		CustomerDTO resCustomerDTO = null;
		try{
			custId = customerDAO.insertCustomer(customerDTO);
			if(custId!=0){
				resCustomerDTO = customerDAO.getCutomerDetailsById(custId);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
		return resCustomerDTO;
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO) throws Exception {// TODO Auto-generated method stub
		boolean result = false;
		CustomerDTO resCustomerDTO = null;
		try{
			result = customerDAO.editCustomer(customerDTO);
			if(result){
				resCustomerDTO = customerDAO.getCutomerDetailsById(customerDTO.getCustId());
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage(), e);
		}
		return resCustomerDTO;
	}


	
	/**
	 * @return the customerDAO
	 */
	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	/**
	 * @param customerDAO the customerDAO to set
	 */
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	}
