package com.hostel.commandline;

import java.util.Map;

public class CommandDTO {
	
	private String cmdName;
	
	private String subCmdName;
		
	private Map<String, String> cmdParams;
	
	// Will be used only for order booking
	private String prvCmdName;
	
	
	
	/**
	 * @return the prvCmdName
	 */
	public String getPrvCmdName() {
		return prvCmdName;
	}
	/**
	 * @param prvCmdName the prvCmdName to set
	 */
	public void setPrvCmdName(String prvCmdName) {
		this.prvCmdName = prvCmdName;
	}
	/**
	 * @return the subCmdName
	 */
	public String getSubCmdName() {
		return subCmdName;
	}
	/**
	 * @param subCmdName the subCmdName to set
	 */
	public void setSubCmdName(String subCmdName) {
		this.subCmdName = subCmdName;
	}
	/**
	 * @return the cmdName
	 */
	public String getCmdName() {
		return cmdName;
	}
	/**
	 * @param cmdName the cmdName to set
	 */
	public void setCmdName(String cmdName) {
		this.cmdName = cmdName;
	}
	/**
	 * @return the cmdParams
	 */
	public Map<String, String> getCmdParams() {
		return cmdParams;
	}
	/**
	 * @param cmdParams the cmdParams to set
	 */
	public void setCmdParams(Map<String, String> cmdParams) {
		this.cmdParams = cmdParams;
	}
	
	

}
