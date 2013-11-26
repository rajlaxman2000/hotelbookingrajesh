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

		customerDTO.setFirstName("gouse");
		customerDTO.setEmailId("gmohiddin@gmail.com");
		customerDTO.setLastName("mohiddin");
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

	}

	public void testSearchCustomerByCriteria() throws Exception {

		List<CustomerDTO> customerDTOsResult = customerServiceImpl
				.searchCustomerByCriteria(customerDTO.getFirstName(),
						customerDTO.getLastName(), customerDTO.getEmailId());

	}

	public void testAddCustomer() throws Exception {
		CustomerDTO result = customerServiceImpl.addCustomer(customerDTO);
		assertEquals("gouse", result.getFirstName());
	}

}
