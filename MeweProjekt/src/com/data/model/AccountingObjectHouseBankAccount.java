package com.data.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("HouseBankAccount")
public class AccountingObjectHouseBankAccount extends AccountingObjectCategory {

	private BankReference bankReference;

	public BankReference getBankReference() {
		return bankReference;
	}

	public void setBankReference(BankReference bankReference) {
		this.bankReference = bankReference;
	}

	
}
