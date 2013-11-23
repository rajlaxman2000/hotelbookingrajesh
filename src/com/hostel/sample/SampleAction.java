package com.hostel.sample;
import com.opensymphony.xwork2.ActionSupport;

public class SampleAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String username;
	 private String password;
	 
	 public String execute() {
		 if (this.username.equals("admin") && this.password.equals("admin123")) {
	            return "success";
	        } else {
	        	addActionError(getText("error.login"));
	            return "error";
	        }
	 }

	    
	 /**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
}
