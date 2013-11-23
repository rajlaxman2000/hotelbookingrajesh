package com.hostel.test;

import com.hostel.mailservice.EmailSendingService;
import com.hostel.mailservice.EmailSendingServiceImpl;
import com.hostel.model.MailDTO;


public class MailTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EmailSendingService emailSendingService;		
		emailSendingService = new EmailSendingServiceImpl();
			MailDTO mailDTO = new MailDTO();
				
			mailDTO.setTargetMailId("rajduvvi@gmail.com");
			mailDTO.setMailBody("Please consider this as test body");
			mailDTO.setMailSubject("Test subject");
		emailSendingService.sendMail(mailDTO);
	}

}
