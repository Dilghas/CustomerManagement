package com.empay.valueobject;

public class CustomerManagementValueObject {
	public CustomerManagementValueObject(){
		serialNumber =123;
	}
	private Integer serialNumber;
	private String  customerTitle;
	private String  customerFirstName;
	private String customerMiddleName;
	private String customerLastName;
	private Integer customerAge;
	private String customerDateOfBirth;
	private String customerCountry;
	private String customerGender;
	private String customerAddressOne;
	private String customerAddressTwo;
	private Double customerAmount;
	private String customerFullName;
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public String getCustomerTitle() {
		return customerTitle;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public String getCustomerMiddleName() {
		return customerMiddleName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public Integer getCustomerAge() {
		return customerAge;
	}
	public String getCustomerDateOfBirth() {
		return customerDateOfBirth;
	}
	public String getCustomerCountry() {
		return customerCountry;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public String getCustomerAddressOne() {
		return customerAddressOne;
	}
	public String getCustomerAddressTwo() {
		return customerAddressTwo;
	}
	public Double getCustomerAmount() {
		return customerAmount;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	public void setCustomerTitle(String customerTitle) {
		this.customerTitle = customerTitle;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public void setCustomerMiddleName(String customerMiddleName) {
		this.customerMiddleName = customerMiddleName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}
	public void setCustomerDateOfBirth(String customerDateOfBirth) {
		this.customerDateOfBirth = customerDateOfBirth;
	}
	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public void setCustomerAddressOne(String customerAddressOne) {
		this.customerAddressOne = customerAddressOne;
	}
	public void setCustomerAddressTwo(String customerAddressTwo) {
		this.customerAddressTwo = customerAddressTwo;
	}
	public void setCustomerAmount(Double customerAmount) {
		this.customerAmount = customerAmount;
	}
	public String getCustomerFullName() {
		return customerFullName;
	}
	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}
}
