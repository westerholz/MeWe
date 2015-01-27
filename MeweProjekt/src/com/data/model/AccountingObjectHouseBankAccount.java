package com.data.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("HouseBankAccount")
public class AccountingObjectHouseBankAccount extends AccountingObjectCategory {

//	private OnlineBankingParameters onlineParams;
//	//@OneToOne
//	//@Column(name="BankReference")
//	private BankReference bankReference;
//	
//	
//	public OnlineBankingParameters getOnlineBankingParams(){
//		return onlineParams;
//	}
//
//	public void setOnlineBankingParameters(OnlineBankingParameters params){
//		this.onlineParams = params;
//	}
//
//	public BankReference getBankReference() {
//		return bankReference;
//	}
//
//	public void setBankReference(BankReference bankReference) {
//		this.bankReference = bankReference;
//	}

	
}
