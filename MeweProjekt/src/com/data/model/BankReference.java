package com.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private long id;
	private String NationalBankAccountNumber; //"alte" Kontonummer
	private String NationalBankCode; //BLZ
	
	private String IBAN;
	private String BIC;
	
	private boolean defaultBankReference;

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
		return IBAN;
	}

	public void setIBAN(String iban) {
		IBAN = iban;
	}

	public String getBIC() {
		return BIC;
	}

	public void setBIC(String bic) {
		BIC = bic;
	}

	public boolean isDefaultBankReference() {
		return defaultBankReference;
	}

	public void setDefaultBankReference(boolean defaultBankReference) {
		this.defaultBankReference = defaultBankReference;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}