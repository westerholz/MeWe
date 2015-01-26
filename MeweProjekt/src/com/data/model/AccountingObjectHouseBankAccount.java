package com.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AccountingObjectHousebankAccounts")
public class AccountingObjectHouseBankAccount implements AccountingObject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	@OneToMany
	private OnlineBankingParameters onlineParams;
	private BankReference bankReference;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public OnlineBankingParameters getOnlineBankingParams(){
		return onlineParams;
	}

	public void setOnlineBankingParameters(OnlineBankingParameters params){
		this.onlineParams = params;
	}

	public BankReference getBankReference() {
		return bankReference;
	}

	public void setBankReference(BankReference bankReference) {
		this.bankReference = bankReference;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}
