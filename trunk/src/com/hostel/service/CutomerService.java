package com.hostel.service;

import com.hostel.model.CustomerDTO;

public interface CutomerService {

	public CustomerDTO getCutomerDetailsById(int cutomerId);

	public CustomerDTO searchCutomerDetailsByHandle(String emailFaceBookTwitterId);
		
}
