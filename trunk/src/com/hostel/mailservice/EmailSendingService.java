package com.hostel.mailservice;



import com.hostel.model.MailDTO;

public interface EmailSendingService {
	/**
	 * TODO: please provide vaalid credentials 
	 */
	final String username="rajlaxmaniitg@gmail.com";	
	final String password = "Laxmana3#";

	public boolean sendMail(MailDTO mailDTO);
	
}
