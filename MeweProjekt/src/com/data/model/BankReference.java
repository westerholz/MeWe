package com.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Table;

/**
 * A bank reference of a contact.
 * One could consider to split this in several sub-objects, like "German Bank Reference" and "SEPA Bank Reference".
 * @author D049283
 *
 */
@Entity
@Table(name="BankReference")
public class BankReference {

	//TODO DIscuss: BankReferences als Subtypen GermanBankReference und SEPABankReference?
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BankReferenceId")
	private long bankReferenceId;
	@Column(name="NationalBankAccountNumber")
	private String NationalBankAccountNumber; //"alte" Kontonummer
	@Column(name="NationalBankCode")
	private String NationalBankCode; //BLZ
	@ManyToOne
	@JoinColumn(name="contact")
	private Contact contact;
	@Column(name="IBAN")
	private String IBAN;
	@Column(name="BIC")
	private String BIC;

	public String getNationalBankAccountNumber() {
		return NationalBankAccountNumber;
	}

	public void setNationalBankAccountNumber(String nationalBankAccountNumber) {
		NationalBankAccountNumber = nationalBankAccountNumber;
	}

	public String getNationalBankCode() {
		return NationalBankCode;
	}

	public void setNationalBankCode(String nationalBankCode) {
		NationalBankCode = nationalBankCode;
	}

	public String getIBAN() {
		return this.IBAN;
	}

	public void setIBAN(String iban) {
		this.IBAN = iban;
	}

	public String getBIC() {
		return BIC;
	}
	public boolean isDefaultReference(){
		return (this.contact.getDefaultBankReference().getBankReferenceId() == this.getBankReferenceId());
	}
	public void setBIC(String bic) {
		BIC = bic;
	}

	public long getBankReferenceId() {
		return bankReferenceId;
	}

	public void setBankReferenceId(long bankReferenceId) {
		this.bankReferenceId = bankReferenceId;
	}

	
}