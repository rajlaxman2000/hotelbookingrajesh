package com.hostel.test;


import com.hostel.model.MailDTO;
import com.hostel.util.*;


public class MailTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EmailSendingService emailSendingService;		
		emailSendingService = new EmailSendingServiceImpl();
			MailDTO mailDTO = new MailDTO();
				
			mailDTO.setTargetMailId("testmail@gmail.com");
			mailDTO.setMailBody("Please consider this as test body");
			mailDTO.setMailSubject("Test subject");
		emailSendingService.sendMail(mailDTO);
	}

}
