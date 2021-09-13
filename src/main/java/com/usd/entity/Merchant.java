package com.usd.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="merchant")
public class Merchant {
	
	@Id
	@GeneratedValue
	private int customerId;

	private String  merchantEmail;
	
	private String accountNumber;

	private String prefix;
	
	private String  firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String panCardNumber;
	
	private String form60;
	
	private String updatesAdharaarCardNumberBankRecords;
	
	private String linkYourAadharNumberPrimaryAccountNumber; 

	private String occupation;
	
	private String sourceofFunds;
	
	private String grossAnnualIncome;
	
	private String residenceType;
	
	private String mailingAddressContactDetails;
	
	private String addressProof;
	
	private String identityProof;

	public Merchant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Merchant(int customerId) {
		super();
		this.customerId = customerId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getMerchantEmail() {
		return merchantEmail;
	}

	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPanCardNumber() {
		return panCardNumber;
	}

	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}

	public String getForm60() {
		return form60;
	}

	public void setForm60(String form60) {
		this.form60 = form60;
	}

	public String getUpdatesAdharaarCardNumberBankRecords() {
		return updatesAdharaarCardNumberBankRecords;
	}

	public void setUpdatesAdharaarCardNumberBankRecords(String updatesAdharaarCardNumberBankRecords) {
		this.updatesAdharaarCardNumberBankRecords = updatesAdharaarCardNumberBankRecords;
	}

	public String getLinkYourAadharNumberPrimaryAccountNumber() {
		return linkYourAadharNumberPrimaryAccountNumber;
	}

	public void setLinkYourAadharNumberPrimaryAccountNumber(String linkYourAadharNumberPrimaryAccountNumber) {
		this.linkYourAadharNumberPrimaryAccountNumber = linkYourAadharNumberPrimaryAccountNumber;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSourceofFunds() {
		return sourceofFunds;
	}

	public void setSourceofFunds(String sourceofFunds) {
		this.sourceofFunds = sourceofFunds;
	}

	public String getGrossAnnualIncome() {
		return grossAnnualIncome;
	}

	public void setGrossAnnualIncome(String grossAnnualIncome) {
		this.grossAnnualIncome = grossAnnualIncome;
	}

	public String getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}

	public String getMailingAddressContactDetails() {
		return mailingAddressContactDetails;
	}

	public void setMailingAddressContactDetails(String mailingAddressContactDetails) {
		this.mailingAddressContactDetails = mailingAddressContactDetails;
	}

	public String getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(String addressProof) {
		this.addressProof = addressProof;
	}

	public String getIdentityProof() {
		return identityProof;
	}

	public void setIdentityProof(String identityProof) {
		this.identityProof = identityProof;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Merchant [customerId=" + customerId + ", merchantEmail=" + merchantEmail + ", accountNumber="
				+ accountNumber + ", prefix=" + prefix + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", panCardNumber=" + panCardNumber + ", form60=" + form60
				+ ", updatesAdharaarCardNumberBankRecords=" + updatesAdharaarCardNumberBankRecords
				+ ", linkYourAadharNumberPrimaryAccountNumber=" + linkYourAadharNumberPrimaryAccountNumber
				+ ", occupation=" + occupation + ", sourceofFunds=" + sourceofFunds + ", grossAnnualIncome="
				+ grossAnnualIncome + ", residenceType=" + residenceType + ", mailingAddressContactDetails="
				+ mailingAddressContactDetails + ", addressProof=" + addressProof + ", identityProof=" + identityProof
				+ "]";
	}

	
}
