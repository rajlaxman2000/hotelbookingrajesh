package com.hostel.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.hostel.dao.CustomerDAO;
import com.hostel.dao.rowmapper.CustomerRowMapper;
import com.hostel.dao.rowmapper.HostelRowMapper;
import com.hostel.model.CustomerDTO;
import com.hostel.model.HostelDTO;


public class CustomerDAOImpl extends GenericDAO implements CustomerDAO {
	
	private CustomerRowMapper customerRowMapper;
	
	@Override
	public CustomerDTO getCutomerDetailsById(int custId) throws Exception{
		List<CustomerDTO> customers;
		Map<String, Object> paramMap = new HashMap<String, Object>(1);
		paramMap.put("customerId", custId);
		try {
			customers = jdbcTemplate.query(getCustByIdQuery, paramMap, customerRowMapper);
			
		} catch(DataAccessException e) {
			throw new Exception(e.getMessage(), e);
		}
		return customers.get(0);
	}

	@Override
	public List<CustomerDTO> searchCutomer(String firstName, String lastName,String email) throws Exception{		
		List<CustomerDTO> customers = null;
		Map<String, Object> paramMap = new HashMap<String, Object>(3);
		StringBuilder qryStr = new StringBuilder(searchCustomerQuery);
		
		if(firstName!=null){
			paramMap.put("firstName", firstName);
			qryStr.append(" first_name=:firstName");
		}	
		if(lastName!=null){
			paramMap.put("lastName", lastName);
			if(firstName!= null){				
				qryStr.append(" or last_name=:lastName");
			}else{				
				qryStr.append("last_name=:lastName");
			}			
		}
		if(email!=null){
			paramMap.put("email", email);
			if(firstName == null && lastName == null){
				qryStr.append("email=:email");
			}else if(firstName != null || lastName!=null){
				qryStr.append(" or email=:email");
			}
		}	
		
		try {
			customers = jdbcTemplate.query(qryStr.toString(), paramMap, customerRowMapper);
		} catch(DataAccessException e) {
			throw new Exception(e.getMessage(), e);
		}
		return customers;
	}
	
	
	
	/**
	 * @return the customerRowMapper
	 */
	public CustomerRowMapper getCustomerRowMapper() {
		return customerRowMapper;
	}

	/**
	 * @param customerRowMapper the customerRowMapper to set
	 */
	public void setCustomerRowMapper(CustomerRowMapper customerRowMapper) {
		this.customerRowMapper = customerRowMapper;
	}

	public boolean editCustomer(CustomerDTO customerDTO) throws Exception {		
		StringBuilder updateQuery = new StringBuilder();
		StringBuilder editQuBuilder = new StringBuilder();
			editQuBuilder.append("update customer set ");
			if(customerDTO.getFirstName()!=null)
				updateQuery.append(" first_name=:firstName ");			
			if(customerDTO.getLastName()!=null){
				if(updateQuery.length()>1){				
					updateQuery.append(" ,last_name=:lastName ");
				}else{
					updateQuery.append(" last_name=:lastName ");
				}
			}	
			if(customerDTO.getEmailId()!=null){
				if(updateQuery.length()>1){	
					updateQuery.append(" ,email=:emailId ");
				}else{
					updateQuery.append(" email=:emailId ");
				}	
			}	
			if(customerDTO.getCcNumber()!=null){
				if(updateQuery.length()>1){
					updateQuery.append(" ,cc_number=:ccNumber ");
				}else{
					updateQuery.append(" cc_number=:ccNumber ");
				}
			}	
			if(customerDTO.getExpDate()!=null){
				if(updateQuery.length()>1){
					updateQuery.append(" ,expiration_date=:expDate ");
				}else{
					updateQuery.append(" expiration_date=:expDate ");
				}
			}	
			if(customerDTO.getSecurityCode()!=null)
				if(updateQuery.length()>1){
					updateQuery.append(" ,security_code=:securityCode ");
				}else{
					updateQuery.append(" security_code=:securityCode ");
				}
			if(customerDTO.getPhone()!=null){
				if(updateQuery.length()>1){
					updateQuery.append(" ,phone=:phone ");
				}else{
					updateQuery.append(" phone=:phone ");
				}
			}	
			
			updateQuery.append(" where customer_id=:customerId");
			editQuBuilder.append(updateQuery.toString());
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap = buildParamsMap(paramMap, customerDTO);
			jdbcTemplate.update(editQuBuilder.toString(), paramMap);
		return true;
	}
	
	@Override
	public int insertCustomer(CustomerDTO customerDTO) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap = buildParamsMap(paramMap, customerDTO);
		Number customerId;
		try{
			SqlParameterSource namedParameters = new MapSqlParameterSource(paramMap);			
			KeyHolder keyHolder = new GeneratedKeyHolder();
			
			jdbcTemplate.update(insertQuery, namedParameters,keyHolder);
			customerId = keyHolder.getKey();
		} catch(DataAccessException e) {
			throw new Exception(e.getMessage(), e);
		}
		return customerId.intValue();
	}
	
	private Map<String,Object> buildParamsMap(Map<String, Object> map, CustomerDTO customerDTO){
		//(:firstName,:lastName,:emailId,:ccNumber,:expDate,:securityCode,:phone)   ";
		map.put("firstName", customerDTO.getFirstName());
		if(customerDTO.getLastName()!=null)
			map.put("lastName", customerDTO.getLastName());
		if(customerDTO.getEmailId()!=null)
			map.put("emailId", customerDTO.getEmailId());
		if(customerDTO.getCcNumber()!=null)
			map.put("ccNumber",customerDTO.getCcNumber());
		else
			map.put("ccNumber","");
		if(customerDTO.getExpDate()!=null)
			map.put("expDate", customerDTO.getExpDate());
		else
			map.put("expDate", "");
		if(customerDTO.getSecurityCode()!=null)
			map.put("securityCode", customerDTO.getSecurityCode());
		else
			map.put("securityCode", "");
		if(customerDTO.getPhone()!=null)
			map.put("phone",customerDTO.getPhone());
		else
			map.put("phone",null);
		if(customerDTO.getCustId()!=0)
			map.put("customerId",customerDTO.getCustId());
		
			
		return map;
	}
	

}
