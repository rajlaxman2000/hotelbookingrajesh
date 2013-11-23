package com.hostel.model;

public class MailDTO {
	
	private String targetMailId;
	private String mailSubject;
	private String mailBody;
	/**
	 * @return the targetMailId
	 */
	public String getTargetMailId() {
		return targetMailId;
	}
	/**
	 * @param targetMailId the targetMailId to set
	 */
	public void setTargetMailId(String targetMailId) {
		this.targetMailId = targetMailId;
	}
	/**
	 * @return the mailSubject
	 */
	public String getMailSubject() {
		return mailSubject;
	}
	/**
	 * @param mailSubject the mailSubject to set
	 */
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	/**
	 * @return the mailBody
	 */
	public String getMailBody() {
		return mailBody;
	}
	/**
	 * @param mailBody the mailBody to set
	 */
	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

}
