package com.hostel.util;



import com.hostel.model.MailDTO;

public interface EmailSendingService {
	/**
	 * TODO: please provide valid credentials 
	 */
	final String username="gsankineni@gmail.com";	
	final String password = "honeynani";

	public boolean sendMail(MailDTO mailDTO);
	
}
