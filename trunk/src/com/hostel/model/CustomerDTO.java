package com.hostel.model;

public class CustomerDTO {
	
	private int custId;
	private String custName;
	private String custMailId;
	private String custFaceBookId;
	private String custTwitterId;
	private int age;
	private char gender;
	private AddressDTO addressDTO;
	
	/**
	 * @return the custId
	 */
	public int getCustId() {
		return custId;
	}
	/**
	 * @param custId the custId to set
	 */
	public void setCustId(int custId) {
		this.custId = custId;
	}
	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}
	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/**
	 * @return the custMailId
	 */
	public String getCustMailId() {
		return custMailId;
	}
	/**
	 * @param custMailId the custMailId to set
	 */
	public void setCustMailId(String custMailId) {
		this.custMailId = custMailId;
	}
	/**
	 * @return the custFaceBookId
	 */
	public String getCustFaceBookId() {
		return custFaceBookId;
	}
	/**
	 * @param custFaceBookId the custFaceBookId to set
	 */
	public void setCustFaceBookId(String custFaceBookId) {
		this.custFaceBookId = custFaceBookId;
	}
	/**
	 * @return the custTwitterId
	 */
	public String getCustTwitterId() {
		return custTwitterId;
	}
	/**
	 * @param custTwitterId the custTwitterId to set
	 */
	public void setCustTwitterId(String custTwitterId) {
		this.custTwitterId = custTwitterId;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}
	/**
	 * @return the addressDTO
	 */
	public AddressDTO getAddressDTO() {
		return addressDTO;
	}
	/**
	 * @param addressDTO the addressDTO to set
	 */
	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}
	

}
