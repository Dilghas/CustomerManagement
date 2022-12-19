package com.empay.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_MANAGEMENT")
public class CustomerManagementEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="CST_SER_NUMBER")
	private Integer serialNumber;
	
	@Column(name="CST_LAST_UPDATE")
	private java.util.Date lastUpdate;
	
	@Column(name="CST_UPDATED_USER")
	private Integer updatedUser;
	
	@Column(name="CST_INS_CODE")
	private Integer institutionCode;
	
	@Column(name="CST_TITLE")
	private String customerTitle;
	
	@Column(name="CST_FIRST_NAME")
	private String customerFirstName;
	
	@Column(name="CST_MIDDLE_NAME")
	private String customerMiddleName;
	
	@Column(name="CST_LAST_NAME")
	private String customerLastName;
	
	@Column(name="CST_DATE_OF_BIRTH")
	private Date customerDateOfBirth;
	
	@Column(name="CST_AGE")
	private Integer customerAge;
	
	@Column(name="CST_COUNTRY")
	private String customerCountry;
	
	@Column(name="CST_GENDER")
	private String customerGender;
	
	@Column(name="CST_ADDRESS_ONE")
	private String customerAddresOne;
	
	@Column(name="CST_ADDRESS_TWO")
	private String customerAddresTwo;
	
	@Column(name="CST_AMOUNT")
	private Double customerAmount;

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public java.util.Date getLastUpdate() {
		return lastUpdate;
	}

	public Integer getUpdatedUser() {
		return updatedUser;
	}

	public Integer getInstitutionCode() {
		return institutionCode;
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

	public Date getCustomerDateOfBirth() {
		return customerDateOfBirth;
	}

	public Integer getCustomerAge() {
		return customerAge;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public String getCustomerAddresOne() {
		return customerAddresOne;
	}

	public String getCustomerAddresTwo() {
		return customerAddresTwo;
	}

	public Double getCustomerAmount() {
		return customerAmount;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setLastUpdate(java.util.Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public void setUpdatedUser(Integer updatedUser) {
		this.updatedUser = updatedUser;
	}

	public void setInstitutionCode(Integer institutionCode) {
		this.institutionCode = institutionCode;
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

	public void setCustomerDateOfBirth(Date customerDateOfBirth) {
		this.customerDateOfBirth = customerDateOfBirth;
	}

	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public void setCustomerAddresOne(String customerAddresOne) {
		this.customerAddresOne = customerAddresOne;
	}

	public void setCustomerAddresTwo(String customerAddresTwo) {
		this.customerAddresTwo = customerAddresTwo;
	}

	public void setCustomerAmount(Double customerAmount) {
		this.customerAmount = customerAmount;
	}
	
}
