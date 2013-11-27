package com.hostel.junit;

import java.util.ArrayList;
import java.util.List;
import org.mockito.Mockito;
import com.hostel.dao.CustomerDAO;
import com.hostel.model.CustomerDTO;
import com.hostel.service.impl.CustomerServiceImpl;
import junit.framework.TestCase;

public class CustomerServiceImplTest extends TestCase {

	CustomerDAO customerDAO;
	CustomerServiceImpl customerServiceImpl;
	CustomerDTO customerDTO = new CustomerDTO();
	List<CustomerDTO> myParamList;

	@Override
	public void setUp() throws Exception {

		customerDTO.setFirstName("geetha");
		customerDTO.setEmailId("gsankineni@gmail.com");
		customerDTO.setLastName("sankineni");
		myParamList = new ArrayList<CustomerDTO>();
		myParamList.add(customerDTO);

		customerServiceImpl = new CustomerServiceImpl();
		customerDAO = Mockito.mock(CustomerDAO.class);
		customerServiceImpl.setCustomerDAO(customerDAO);

		Mockito.when(
				customerDAO.searchCutomer(customerDTO.getFirstName(),
						customerDTO.getLastName(), customerDTO.getEmailId()))
				.thenReturn(myParamList);

		Mockito.when(customerDAO.insertCustomer(customerDTO)).thenReturn(1);

		Mockito.when(customerDAO.getCutomerDetailsById(1)).thenReturn(
				customerDTO);

		Mockito.when(customerDAO.editCustomer(customerDTO)).thenReturn(true);

		Mockito.when(customerDAO.getCutomerDetailsById(1)).thenReturn(
				customerDTO);

	}

	public void testSearchCustomerByCriteria() throws Exception {

		List<CustomerDTO> customerDTOsResult = customerServiceImpl
				.searchCustomerByCriteria("geetha", "sankineni",
						"gsankineni@gmail.com");
		assertEquals("geetha", customerDTOsResult.get(0).getFirstName());
	}

	public void testAddCustomer() throws Exception {
		CustomerDTO result = customerServiceImpl.addCustomer(customerDTO);
		assertEquals("geetha", result.getFirstName());
	}

	public void testUpdateCustomer() throws Exception {
		customerDTO.setCustId(1);
		CustomerDTO customerDTOresult = customerServiceImpl
				.updateCustomer(customerDTO);
		assertEquals("geetha", customerDTOresult.getFirstName());
	}
}
